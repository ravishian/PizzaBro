package com.soni5.pizzabro.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.soni5.pizzabro.Manager.AddProductFragment;
import com.soni5.pizzabro.Manager.OfferManagerFragment;
import com.soni5.pizzabro.R;
import com.soni5.pizzabro.databinding.ActivityCmainBinding;
import com.soni5.pizzabro.databinding.ActivityMainBinding;

public class C_MainActivity extends AppCompatActivity {

    ActivityCmainBinding bindingl;


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmain);


        replacefragment(new HomeFragment());
        bindingl = ActivityCmainBinding.inflate(getLayoutInflater());

        bindingl.bottomNavigationView.setOnItemSelectedListener(item -> {



            if (item.getItemId() == R.id.homeb)
            {
                replacefragment(new HomeFragment());
            }
            else if
            (item.getItemId() == R.id.profileb)
            {
                replacefragment(new AddProductFragment());
            }



            return true;
        });

    }


    private  void replacefragment(Fragment fragment)
    {
        FragmentManager fragmentmanger = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentmanger.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout2,fragment);
        fragmentTransaction.commit();
    }
}