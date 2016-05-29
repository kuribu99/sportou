package sports2u.com.sportou;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Kong My on 28/5/2016.
 */
public class SelectSportDialog extends AlertDialog {

    private final Context context;
    private final EditText tbx;

    public SelectSportDialog(Context context, EditText tbx) {
        super(context);
        this.context = context;
        this.tbx = tbx;
    }

    public void ShowDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = getLayoutInflater().inflate(R.layout.dialog_sports, null);
        final RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
        Button btn = (Button) view.findViewById(R.id.btn_confirm);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton radioButton = (RadioButton) findViewById(radioGroup .getCheckedRadioButtonId());
                tbx.setText(radioButton.getText());
            }
        });

        builder.setView(view);
        builder.create().show();

    }
}
