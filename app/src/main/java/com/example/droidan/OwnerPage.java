package com.example.droidan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class OwnerPage extends AppCompatActivity {
    // DatabaseReference dbRef;
    // Button chs,sub;
    // EditText map,des,beds,phoneno;
    // StorageReference nStorageRef;
    // public Uri imguri;
    // private StorageTask uploadTask;
    // DatabaseReference boardRef;
    // private ProgressDialog loadingbar;
//
// @Override
// protected void onCreate(Bundle savedInstanceState) {
//     super.onCreate(savedInstanceState);
//     setContentView(R.layout.activity_owner_page);
//     chs=(Button)findViewById(R.id.choosebtn);
//     sub=(Button) findViewById(R.id.submit3);
//     map=(EditText) findViewById(R.id.editTextTextPersonName4) ;
//     des=(EditText) findViewById(R.id.editTextTextPersonName3) ;
//     beds=(EditText) findViewById(R.id.editTextTextPersonName6) ;
//     phoneno=(EditText) findViewById(R.id.phoneno2);
//     nStorageRef= FirebaseStorage.getInstance().getReference("Image");
//     String phonen=phoneno.getText().toString();
//     boardRef=FirebaseDatabase.getInstance().getReference().child("hostels")//;
//     loadingbar = new ProgressDialog(this);
//     chs.setOnClickListener(new View.OnClickListener() {
//         @Override
//         public void onClick(View view) {

//            Filechooser();
//         }
//     });
//     sub.setOnClickListener(new View.OnClickListener() {
//         @Override
//         public void onClick(View view) {
//             if (uploadTask != null && uploadTask.isInProgress()) {
//                 Toast.makeText(OwnerPage.this,"Upload in progress",Toast.LENGTH_SHORT).show();
//             } else {
//                 Fileuploader();

//             }
//             Intent i = new Intent(OwnerPage.this, HomePage.class);
//             startActivity(i);
//         }
//     });
// }
//  dbRef = FirebaseDatabase.getInstance().getReference().child(source).child(phoneno);
// private  String getExtension(Uri uri) {
//     ContentResolver cr=getContentResolver();
//     MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
//     return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
// }
// private void Fileuploader() {
//     StorageReference Ref=nStorageRef.child(System.currentTimeMillis()+"."+getExtension(imguri));
//      uploadTask=  Ref.putFile(imguri)
//             .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                 @Override
//                 public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                     // Get a URL to the uploaded content
//                     //  Uri downloadUrl = taskSnapshot.getDownloadUrl();
//                     Toast.makeText(OwnerPage.this, "Image Uploaded SuccesFully", Toast.LENGTH_SHORT).show();
//                     saveBoardingInformation();
//                 }
//             })
//             .addOnFailureListener(new OnFailureListener() {
//                 @Override
//                 public void onFailure(@NonNull Exception exception) {
//                     // Handle unsuccessful uploads
//                     // ...
//                 }

//             });
// }

// private void saveBoardingInformation() {
//     String Description = des.getText().toString();
//     String Maplink = map.getText().toString();
//     String Nofbeds =beds.getText().toString();
//     String phonen=phoneno.getText().toString();
//     if (TextUtils.isEmpty(Description)) {
//         Toast.makeText(this, "Insert Description", Toast.LENGTH_SHORT).show();
//     } else if (TextUtils.isEmpty(Maplink)) {
//         Toast.makeText(this, "Insert Maplink", Toast.LENGTH_SHORT).show();
//     } else if (TextUtils.isEmpty(Nofbeds)) {
//         Toast.makeText(this, "Insert Number of beds Available", Toast.LENGTH_SHORT).show();}
//         else if (TextUtils.isEmpty(phonen)) {
//             Toast.makeText(this, "Insert Phone number", Toast.LENGTH_SHORT).show();
//         }
//      else {
//         loadingbar.setTitle("Create Account");
//         loadingbar.setMessage("Please wait..");
//         loadingbar.setCanceledOnTouchOutside(false);
//         loadingbar.show();


//     }
//     HashMap< String,Object>boardmap =new HashMap<>();
//     boardmap.put("Description",des);
//     boardmap.put("Maplink",map);
//     boardmap.put("NumberofBeds",beds);
//     boardmap.put("Image",imguri);
//     boardmap.put("PhoneNo",phoneno);
//     boardRef.child(phonen).updateChildren(boardmap).addOnCompleteListener(new OnCompleteListener<Void>() {
//         @Override
//         public void onComplete(@NonNull Task<Void> task) {
//             if (task.isSuccessful()){
//                 Toast.makeText(OwnerPage.this,"Hostel is Added sucessfuly",Toast.LENGTH_SHORT).show();
//             }
//         }
//     });

// }


// private void Filechooser() {
//     Intent intent = new Intent();
//     intent.setType("image/*");
//     intent.setAction(Intent.ACTION_GET_CONTENT);
//     startActivityForResult(intent, 1);
// }

// @Override
// protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//     super.onActivityResult(requestCode, resultCode, data);
//     if(requestCode == 1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
//         imguri=data.getData();
//     }
// }
}