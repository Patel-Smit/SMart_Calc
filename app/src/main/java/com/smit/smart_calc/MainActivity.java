package com.smit.smart_calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv_res;
    private TextView tv_op;
    private boolean op_clicked = false;
    private String op_last;
    private float v1 = 0, v2 = 0;


// Group 11
// Final Phase
// Smitkumar Patel - 1893467
// Mihirkumar Patel - 1892917

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_res = (TextView) findViewById(R.id.textView_res);
        tv_op = (TextView) findViewById(R.id.textView_op);

        Button buttonPower = findViewById(R.id.powerButton);
        registerForContextMenu(buttonPower);
        Button buttonTrignometry = findViewById(R.id.trignometryButton);
        registerForContextMenu(buttonTrignometry);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        int id = v.getId();
        if (id == R.id.powerButton) {
            getMenuInflater().inflate(R.menu.raiseto_menu, menu);
        } else if (id == R.id.trignometryButton) {
            getMenuInflater().inflate(R.menu.trignometry_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.square:
                if (tv_res.getText().toString().isEmpty()) {
                    return true;
                } else {
                    Toast.makeText(this, "X to power 2", Toast.LENGTH_SHORT).show();
                    tv_res.setText(Math.pow(Float.parseFloat(tv_res.getText().toString()), 2) + "");
                    if (tv_op.getText().toString().isEmpty())
                        tv_op.setText(tv_res.getText());
                    return true;
                }
            case R.id.cube:
                if (tv_res.getText().toString().isEmpty()) {
                    return true;
                } else {
                    Toast.makeText(this, "X to power 3", Toast.LENGTH_SHORT).show();
                    tv_res.setText(Math.pow(Float.parseFloat(tv_res.getText().toString()), 3) + "");
                    if (tv_op.getText().toString().isEmpty())
                        tv_op.setText(tv_res.getText());
                    return true;
                }
            case R.id.option_sin:
                if (tv_res.getText().toString().isEmpty()) {
                    return true;
                } else {
                    Toast.makeText(this, "sin Function", Toast.LENGTH_SHORT).show();
                    Double tempSin = Double.parseDouble(tv_res.getText().toString());
                    Double tempSin2 = Math.toRadians(tempSin);
                    tv_res.setText(Math.sin(tempSin2) + "");
                    if (tv_op.getText().toString().isEmpty())
                        tv_op.setText(tv_res.getText());
                    return true;
                }
            case R.id.option_cos:
                if (tv_res.getText().toString().isEmpty()) {
                    return true;
                } else {
                    Toast.makeText(this, "sin Function", Toast.LENGTH_SHORT).show();
                    Double tempCos = Double.parseDouble(tv_res.getText().toString());
                    Double tempCos2 = Math.toRadians(tempCos);
                    tv_res.setText(Math.cos(tempCos2) + "");
                    if (tv_op.getText().toString().isEmpty())
                        tv_op.setText(tv_res.getText());
                    return true;
                }
            case R.id.option_tan:
                if (tv_res.getText().toString().isEmpty()) {
                    return true;
                } else {
                Toast.makeText(this, "sin Function", Toast.LENGTH_SHORT).show();
                Double tempTan = Double.parseDouble(tv_res.getText().toString());
                Double tempTan2 = Math.toRadians(tempTan);
                tv_res.setText(Math.tan(tempTan2) + "");
                if (tv_op.getText().toString().isEmpty())
                    tv_op.setText(tv_res.getText());
                return true;
                }

            default:
                return super.onContextItemSelected(item);
        }

    }

    public void button_Trignometry(View v){
        Toast.makeText(this, "Long press to see options", Toast.LENGTH_SHORT).show();
    }

    public void setnumber(String ch) {
        if (op_clicked) {
            tv_res.setText("");
            op_clicked = false;
        }
        tv_res.setText(tv_res.getText().toString() + ch);
    }

    public void setOp(String op) {
        tv_op.setText(tv_op.getText().toString() + " " + tv_res.getText().toString() + op);
    }

    public void setOperator(String ch) {
        if (tv_res.getText().toString().isEmpty()) {
            return;
        } else {
            if (!op_clicked) {
                op_clicked = true;
                op_last = ch;
                v1 = Float.parseFloat(tv_res.getText().toString());
                setOp(ch);
            } else {
                op_last = ch;
                String st = tv_op.getText().toString();
                tv_op.setText(st.substring(0, st.length() - 1) + op_last);
            }
        }
    }


    public void button_Zero(View v) {
        setnumber("0");
    }

    public void button_One(View v) {
        setnumber("1");
    }

    public void button_Two(View v) {
        setnumber("2");
    }

    public void button_Three(View v) {
        setnumber("3");
    }

    public void button_Four(View v) {
        setnumber("4");
    }

    public void button_Five(View v) {
        setnumber("5");
    }

    public void button_Six(View v) {
        setnumber("6");
    }

    public void button_Seven(View v) {
        setnumber("7");
    }

    public void button_Eight(View v) {
        setnumber("8");
    }

    public void button_Nine(View v) {
        setnumber("9");
    }

    public void button_Plus(View v) {
            setOperator("+");
    }

    public void button_Minus(View v) {
            setOperator("-");
    }

    public void button_Division(View v) {
            setOperator("/");
    }

    public void button_Multiplication(View v) {
            setOperator("x");
    }

    public void button_Point(View v) {
        setnumber(".");
    }

    public void button_Equal(View v) {
        if (tv_res.getText().toString().isEmpty()) {
            return;
        } else {
            float res = 0;
            tv_op.setText(tv_op.getText().toString() + tv_res.getText().toString());
            if (!op_last.isEmpty()) {
                v2 = Float.parseFloat(tv_res.getText().toString());
                switch (op_last) {
                    case "+":
                        res = v1 + v2;
                        break;
                    case "-":
                        res = v1 - v2;
                        break;
                    case "x":
                        res = v1 * v2;
                        break;
                    case "/":
                        res = v1 / v2;
                        break;
                    case "^":
                        double tempv1 = Double.parseDouble(Float.toString(v1));
                        double tempv2 = Double.parseDouble(Float.toString(v2));
                        double tempres = Math.pow(tempv1, tempv2);
                        res = Float.parseFloat(Double.toString(tempres));
                        break;
                }

            }
            tv_res.setText(Float.toString(res));
        }
    }

    public void button_Sign(View view) {
        if (tv_res.getText().toString().isEmpty()) {
            return;
        } else {
            tv_res.setText(Float.parseFloat(tv_res.getText().toString()) * (-1) + "");
            if (tv_op.getText().toString().isEmpty())
                tv_op.setText(tv_res.getText());
        }
    }

    public void button_Percentage(View view) {
        if (tv_res.getText().toString().isEmpty()) {
            return;
        } else {
            tv_res.setText(Float.parseFloat(tv_res.getText().toString()) / (100) + "");
            if (tv_op.getText().toString().isEmpty())
                tv_op.setText(tv_res.getText());
        }
    }

    public void button_Radian(View view) {
        if (tv_res.getText().toString().isEmpty()) {
            return;
        } else {
            tv_res.setText(Float.parseFloat(tv_res.getText().toString()) * 3.14 / (180) + "");
            if (tv_op.getText().toString().isEmpty())
                tv_op.setText(tv_res.getText());
        }
    }

    public void button_Square(View view) {
        if (tv_res.getText().toString().isEmpty()) {
            return;
        } else {
            tv_res.setText(Math.pow(Float.parseFloat(tv_res.getText().toString()), 2) + "");
            if (tv_op.getText().toString().isEmpty())
                tv_op.setText(tv_res.getText());
        }
    }

    public void button_RaiseTo(View view) {
        setOperator("^");
    }

    public void button_Factorial(View view) {
        if (tv_res.getText().toString().isEmpty()) {
            return;
        } else {
            float xFactorial = 0;
            float x = Float.parseFloat(tv_res.getText().toString());
            int i, fact = 1;
            for (i = 1; i <= x; i++) {
                fact = fact * i;
            }
            tv_res.setText(fact + "");
            if (tv_op.getText().toString().isEmpty())
                tv_op.setText(tv_res.getText());
        }
    }

    public void button_Backspace(View v) {
        int indx = 0;
        String temps = "";
        if (!tv_res.getText().toString().isEmpty()) {
            temps = tv_res.getText().toString();
            indx = temps.length() - 1;
            temps = temps.substring(0, indx);
            tv_res.setText(temps);

        }
    }

    public void button_Clear(View view) {
        op_clicked = false;
        tv_op.setText("");
        tv_res.setText("");
    }
}
