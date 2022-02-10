package akash.muhundhan.homework2;

import static akash.muhundhan.homework2.R.id.switchToast;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText outText;
    Button btn;

    public void btnSaved_clicked (View view) {
        //DisplayToast("You have clicked the Save button1");
        edittextOut();
    }

    private void edittextOut() {
        outText=findViewById(R.id.txtName);
        Toast.makeText(MainActivity.this, outText.getText(), Toast.LENGTH_SHORT).show();


    }

    private void switchT() {
        Switch simpleSwitch = (Switch) findViewById(switchToast);
        if (simpleSwitch.isChecked()){
            Toast.makeText(MainActivity.this,
                    R.string.switch_Toast_Out,
                    Toast.LENGTH_SHORT).show();

        }

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //---Button view---
        Button btnOpen = findViewById(R.id.btnOpen);
        //register the button with an event listener
        //anonymous class
//implement your event handler method
        btnOpen.setOnClickListener(v -> openBtnOut());

        //---CheckBox---
        CheckBox checkBox = findViewById(R.id.chkAutosave);
        checkBox.setOnClickListener(v -> {
            if (((CheckBox)v).isChecked())
                DisplayToast(getString(R.string.AutoSaveC));
            else
                DisplayToast(getString(R.string.AutoSaveU));
        });

        //---RadioButton---
        RadioGroup radioGroup = findViewById(R.id.rdbGp1);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton rb1 = findViewById(R.id.rdb1);
            if (rb1.isChecked()) {
                DisplayToast("Option 1 checked!");
            } else {
                DisplayToast("Option 2 checked!");
            }
        });

        //---ToggleButton---
        ToggleButton toggleButton =
                findViewById(R.id.toggle1);
        toggleButton.setOnClickListener(v -> {
            if (((ToggleButton) v).isChecked()){
                DisplayToast("Toggle button is On");
            switchT();
        }
            else {
                DisplayToast("Toggle button is Off");
            }
        });
    }

    private void openBtnOut() {
       // DisplayToast(getString(R.string.open_Btn));
        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(MainActivity.this);

        // Set the message show for the Alert time
        builder.setMessage("Do you want to exit ?");

        // Set Alert Title
        builder.setTitle("Alert !");

        // Set Cancelable false
        // for when the user clicks on the outside
        // the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name
        // OnClickListener method is use of
        // DialogInterface interface.

        builder
                .setPositiveButton(
                        "Yes",
                        (dialog, which) -> {

                            // When the user click yes button
                            // then app will close
                            finish();
                        });

        // Set the Negative button with No name
        // OnClickListener method is use
        // of DialogInterface interface.
        builder
                .setNegativeButton(
                        "No",
                        (dialog, which) -> {

                            // If user click no
                            // then dialog box is canceled.
                            dialog.cancel();
                        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();

        // Show the Alert Dialog box
        alertDialog.show();
    }


    private void DisplayToast(String msg)
    {
        Toast.makeText(getBaseContext(), msg,
                Toast.LENGTH_SHORT).show();
    }
}