package com.cement.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.MediaStore.Images.ImageColumns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cement.android.R;
import com.cement.app.App;
import com.cement.server.WebServer;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

	private EditText editText;
	private Button buttonRoot;
	private View setButton;
	private View openButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText = (EditText) findViewById(R.id.edit_text);
		setButton = (Button) findViewById(R.id.button_set_webroot);
		setButton.setOnClickListener(new ConstomClickListener());
		openButton = (Button) findViewById(R.id.button_open_webroot);
		openButton.setOnClickListener(new ConstomClickListener());
//		if (savedInstanceState == null) {
//			getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
//		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	public  String getRealFilePath(final Uri uri ) {
	    if ( null == uri ) return null;
	    final String scheme = uri.getScheme();
	    String data = null;
	    if ( scheme == null )
	        data = uri.getPath();
	    else if ( ContentResolver.SCHEME_FILE.equals( scheme ) ) {
	        data = uri.getPath();
	    } else if ( ContentResolver.SCHEME_CONTENT.equals( scheme ) ) {
	        Cursor cursor = getContentResolver().query( uri, new String[] { ImageColumns.DATA }, null, null, null );
	        if ( null != cursor ) {
	            if ( cursor.moveToFirst() ) {
	                int index = cursor.getColumnIndex( ImageColumns.DATA );
	                if ( index > -1 ) {
	                    data = cursor.getString( index );
	                }
	            }
	            cursor.close();
	        }
	    }
	    return data;
	}
	public void openFileChooser(){
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.addCategory(Intent.CATEGORY_OPENABLE);
		intent.setType("*/*");
		try {
			startActivityForResult(Intent.createChooser(intent, "请选择一个你喜欢的软件"),1000);
		} catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(MainActivity.this, "请安装文件管理器", Toast.LENGTH_SHORT).show();
		}
	}
	  @Override  
	    public void onActivityResult(int requestCode, int resultCode, Intent data) {  
	        if (resultCode == Activity.RESULT_OK && requestCode == 1000) {  
	            Uri uri = data.getData(); 
	            String path = getRealFilePath(uri);
	            editText.setText(path);
	            System.out.println("result: ............................ "+path);
	        }  
	        super.onActivityResult(requestCode, resultCode, data);  
	    }  
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.server_start) {
			Intent intent = new Intent(this,WebServer.class);
			intent.putExtra("command", "start");
			startService(intent);
			
			return true;
		}
		if (id == R.id.server_stop) {
			Intent intent = new Intent(this,WebServer.class);
			intent.putExtra("command", "stop");
			startService(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public class ConstomClickListener implements OnClickListener {

		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			if(view.getId() == R.id.button_set_webroot){
				String webroot = editText.getText().toString();
				if (webroot != null && webroot != "") {
					App.WEBROOT = webroot;
				}
			}
			if(view.getId() == R.id.button_open_webroot){
				MainActivity.this.openFileChooser();
			}
		}

	}
}
