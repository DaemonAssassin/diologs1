package com.gmail.mateendev3.dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    AppCompatButton showDialog1;
    AppCompatButton showDialog2;
    AppCompatButton showDialog3;
    AppCompatButton showDialog4;
    AppCompatButton showDialog5;
    AppCompatButton showDialog6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog1 = findViewById(R.id.show_dialog_1);
        showDialog1.setOnClickListener(v -> {
            showDialog1();
        });

        showDialog2 = findViewById(R.id.show_dialog_2);
        showDialog2.setOnClickListener(v -> {
            showDialog2();
        });

        showDialog3 = findViewById(R.id.show_dialog_3);
        showDialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog3();
            }
        });

        showDialog4 = findViewById(R.id.show_dialog_4);
        showDialog4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog4();
            }
        });

        showDialog5 = findViewById(R.id.show_dialog_5);
        showDialog5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog5();
            }
        });

        showDialog6 = findViewById(R.id.show_dialog_6);
        showDialog6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog6();
            }
        });
    }

    private void showDialog1() {
        Dialog dialog = new Dialog(MainActivity.this, R.style.DialogStyle);
        dialog.setContentView(R.layout.custom_dialog_layout);

        dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_bg);

        ImageView ivIconCancel = dialog.findViewById(R.id.iv_icon_cancel);
        AppCompatButton btnBuy = dialog.findViewById(R.id.btn_buy);
        AppCompatButton btnGoToHome = dialog.findViewById(R.id.btn_go_to_home);

        ivIconCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Added To Cart, Thanks", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        btnGoToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout rootLayout = findViewById(R.id.root_layout);
                Snackbar.make(rootLayout, "Wanna go home?", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Please", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Taking you to home..", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
                dialog.dismiss();
            }
        });

        dialog.setCancelable(false);
        dialog.show();
    }

    private void showDialog2() {
        Dialog dialog = new Dialog(this);
        View v = getLayoutInflater().inflate(R.layout.custom_dialog2, null);
        dialog.setContentView(v);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_bg2);
        dialog.getWindow().setWindowAnimations(R.style.DialogAnimation);
        AppCompatButton okButton = v.findViewById(R.id.btn_okay);
        okButton.setOnClickListener(v1 -> dialog.dismiss());
        dialog.show();
    }

    private void showDialog3() {
        //String[] arr = new String[]{"red", "blue", "green"};

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Pick a color")
                .setItems(R.array.colors, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //String item = arr[which];
                        String item = getResources().getStringArray(R.array.colors)[which];
                        Toast.makeText(MainActivity.this, item + " clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        dialog.show();
    }

    private void showDialog4() {
        String[] games = {"GTA", "IGI", "NFS", "COD", "Valorant"};
        boolean[] favGame = {true, true, true, true, true};

        /*//method 1 using DialogFragment
        MultipleChoiceItem item = new MultipleChoiceItem();
        item.show(getSupportFragmentManager(), "MyFrag");*/

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Choose favorite game")
                .setMultiChoiceItems(games, favGame, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        String game = games[which];
                        if (!isChecked) {
                            Toast.makeText(MainActivity.this, game + " unchecked", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.show();

    }

    private void showDialog5() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Select Gender")
                .setSingleChoiceItems(R.array.genders, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,
                                getResources().getStringArray(R.array.genders)[which] + " clicked",
                                Toast.LENGTH_LONG).show();
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.show();
    }

    private void showDialog6() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.custom_dialog_layout_6, null);
        EditText username = v.findViewById(R.id.username);
        EditText password = v.findViewById(R.id.password);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setPositiveButton("Sign In", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,
                                "username: " + username.getText().toString() + ", password: " + password.getText().toString(),
                                Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setView(v)
                .create();
        dialog.show();
    }

}