package com.iliyas.plaincalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mDisplay;
    private boolean mDisplayIsEmpty = true;
    private boolean mFirstNumberReceived;
    private boolean mNumberEntered;
    private boolean mPointEntered;
    private double sNum1;
    private double sNum2;
    private static OperationsAndFunctions.OperEnum sOperation;
    private static OperationsAndFunctions.FuncEnum sFunction;
    private Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDisplay = (TextView) findViewById(R.id.resultview);
        mDisplay.setText("0");

    }

    public void num_Clicked(View view) {
        Button button = (Button) view;
        int number = 0;

        switch (button.getId()) {

            case R.id.n_one:
                number = 1;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
            case R.id.n_two:
                number = 2;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
            case R.id.n_three:
                number = 3;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
            case R.id.n_four:
                number = 4;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
            case R.id.n_five:
                number = 5;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
            case R.id.n_six:
                number = 6;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
            case R.id.n_seven:
                number = 7;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
            case R.id.n_eight:
                number = 8;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
            case R.id.n_nine:
                number = 9;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
            case R.id.n_zero:
                if (mDisplay.getText().toString().equals("0")) {
                    return;
                }
                number = 0;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
        }
        // setting a new digit onto display if it is empty
        if (mDisplayIsEmpty) {

            if (!(number == 0)) {
                mDisplayIsEmpty = false;
            }
            mDisplay.setText(Integer.toString(number));

        } else {
            // appending digit if display isn't empty
            mDisplay.append(Integer.toString(number));
        }
        mNumberEntered = true;
    }

    public void op_Clicked(View view) {
        Button button = (Button) view;

        if (mNumberEntered) {
            // if received first number and saved to sNum1
            if (mFirstNumberReceived) {
                sNum2 = Double.parseDouble(mDisplay.getText().toString());

                printResult(calculateResult(sNum1, sOperation, sNum2));

                sNum1 = Double.parseDouble(mDisplay.getText().toString());

            } else {
                // if not received first number - receiving it now
                sNum1 = Double.parseDouble(mDisplay.getText().toString());
                mFirstNumberReceived = true;
            }
            mNumberEntered = false;
        }

        switch (button.getId()) {

            case R.id.o_plus:
                sOperation = OperationsAndFunctions.OperEnum.SUM;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
            case R.id.o_minus:
                sOperation = OperationsAndFunctions.OperEnum.SUBSTRACT;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
            case R.id.o_times:
                sOperation = OperationsAndFunctions.OperEnum.MULTIPLY;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
            case R.id.o_divide:
                sOperation = OperationsAndFunctions.OperEnum.DIVIDE;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
            case R.id.o_equals:
                sOperation = OperationsAndFunctions.OperEnum.EQUAL;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
        }
        mDisplayIsEmpty = true;
        mPointEntered = false;

    }

    public void func_Clicked(View view) {
        Button button = (Button) view;
        switch (button.getId()) {
            case R.id.o_ce:
                sFunction = OperationsAndFunctions.FuncEnum.RESET;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;

            case R.id.delete:
                sFunction = OperationsAndFunctions.FuncEnum.BACKSPACE;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;

            case R.id.o_plus_minus:
                sFunction = OperationsAndFunctions.FuncEnum.SIGN;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;

            case R.id.o_percent:
                sFunction = OperationsAndFunctions.FuncEnum.PERCENT;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;

            case R.id.decimal:
                sFunction = OperationsAndFunctions.FuncEnum.POINT;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
            case R.id.o_root:
                sFunction = OperationsAndFunctions.FuncEnum.ROOT;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
            case R.id.o_square:
                sFunction = OperationsAndFunctions.FuncEnum.SQUARE;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
            case R.id.o_cube:
                sFunction = OperationsAndFunctions.FuncEnum.CUBE;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
            case R.id.o_one_of:
                sFunction = OperationsAndFunctions.FuncEnum.ONEBY;
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_anim);
                button.startAnimation(anim);
                break;
        }
        // implementing chosen function
        doFunction(sFunction);
    }


    /**
     * Implementing function according to pressed button.
     * Current functions read current display state,
     * changes it and prints on display again
     */

    private void doFunction(OperationsAndFunctions.FuncEnum function) {
        sFunction = function;

        switch (function) {

            case RESET:
                reset();
                break;

            case BACKSPACE:
                printResult(Double.parseDouble(backSpace(mDisplay.getText()).toString()));
                break;

            case SIGN:
                printResult(readDisplayState() * (-1));
                break;

            case PERCENT:
                printResult(readDisplayState() / 100);
                break;
            case ROOT:
                printResult(Math.sqrt(readDisplayState()));
                break;
            case SQUARE:
                printResult(Math.pow(readDisplayState(), 2));
                break;
            case CUBE:
                printResult(Math.pow(readDisplayState(), 3));
                break;
            case ONEBY:
                try {
                    printResult(1 / readDisplayState());

                } catch (ArithmeticException e) {
                    showError();
                }
                break;

            case POINT:
                if (!mPointEntered) {
                    if (!mDisplayIsEmpty) {
                        mDisplay.append(".");
                    } else {
                        mDisplay.setText("0.");
                        mDisplayIsEmpty = false;
                    }
                    mPointEntered = true;
                }
                break;
        }
    }

    /**
     * reseting the calculator
     * in case of pressing AC button
     */

    private void reset() {
        mDisplay.setText("0");
        sNum1 = sNum2 = 0;
        mDisplayIsEmpty = true;
        mFirstNumberReceived = false;
        mNumberEntered = false;
        mPointEntered = false;
    }

    /**
     * deleting the last symbol on display
     */

    private CharSequence backSpace(CharSequence displayState) {
        CharSequence result = displayState;

        if (displayState.length() > 1) {
            result = displayState.subSequence(0, displayState.length() - 1);

        } else if (displayState.length() == 1) {
            result = "0";
        }

        return result;
    }

    /**
     * calculates the result of operation
     * between two numbers and returns the result in double format
     */

    private double calculateResult(double num1, OperationsAndFunctions.OperEnum operation,
                                   double num2) {

        sNum1 = num1;
        sNum2 = num2;
        sOperation = operation;

        double result = 0;

        switch (operation) {

            case SUM:
                result = num1 + num2;
                break;

            case SUBSTRACT:
                result = num1 - num2;
                break;

            case MULTIPLY:
                result = num1 * num2;
                break;

            case EQUAL:
                mDisplayIsEmpty = true;
                mNumberEntered = false;
                mFirstNumberReceived = false;
                break;

            case DIVIDE:
                // division by zero
                try {
                    result = num1 / num2;

                } catch (ArithmeticException e) {
                    showError();
                }

                break;
        }

        return result;
    }

    /**
     * reads current display number
     */
    private double readDisplayState() {
        return Double.parseDouble(mDisplay.getText().toString());
    }

    /**
     * prints the result onto display
     */
    private void printResult(Double result) {

        /* checking if the result has decimal part
        if not then prints integer value of it without point and zero(s)
        */

        if (result % 1 == 0) {
            mDisplay.setText(Integer.toString(result.intValue()));

        } else {
            mDisplay.setText(Double.toString(result));
        }
    }

    /**
     * Prints error message (in case of division by zero)
     * and reseting current states
     */

    private void showError() {
        mDisplay.setText("Error");
        sNum1 = sNum2 = 0;
        mDisplayIsEmpty = true;
        mFirstNumberReceived = false;
        mNumberEntered = false;
        mPointEntered = false;
    }

}
