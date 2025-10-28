package com.example.project1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class CourseSelectionActivity extends AppCompatActivity {

    private EditText nameEdit;
    private EditText phoneEdit;
    private Button validateButton;
    private RadioGroup courseRadioGroup;
    private CheckBox checkboxClub1;
    private CheckBox checkboxClub2;
    private CheckBox checkboxClub3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course_selection);
        nameEdit = findViewById(R.id.courseSelectionNameEdit);
        phoneEdit = findViewById(R.id.courseSelectPhoneEdit);
        validateButton = findViewById(R.id.courseSelectValidateBtn);
        courseRadioGroup = findViewById(R.id.courseSelectRadioGroup);
        checkboxClub1 = findViewById(R.id.courseSelectClub1Checkbox);
        checkboxClub2 = findViewById(R.id.courseSelectClub2Checkbox);
        checkboxClub3 = findViewById(R.id.courseSelectClub3Checkbox);

        validateButton.setOnClickListener(v -> {
            String name = nameEdit.getText().toString().trim();
            String phone = phoneEdit.getText().toString().trim();

            if (name.isEmpty() || phone.isEmpty()) {
                if (name.isEmpty())
                    nameEdit.setError("Veuiller saisir le nom");
                if (phone.isEmpty())
                    phoneEdit.setError("Veuiller saisir le numéro de téléphone");
                // Toast.makeText(this, "Veuiller remplir le nom et le numéro de téléphone.", Toast.LENGTH_SHORT).show();
                showAlertDialogError("Veuiller remplir le nom et le numéro de téléphone.");
                return;
            }

            if (!name.matches("[a-zA-ZÀ-ÿ\\s]+")) {
                nameEdit.setError("Le nom doit contenir uniquement des lettres");
                showAlertDialogError("Le nom doit contenir uniquement des lettres.");
                return;
            }

            if (!phone.matches("\\d{8}")) {
                phoneEdit.setError("Le numéro de téléphone doit contenir 8 chiffres");
                showAlertDialogError("Veuillez saisir un numéro de téléphone valide (8 chiffres).");
                return;
            }

            String selectedCourse = "Non sélectionné";
            int selectedCourseId = courseRadioGroup.getCheckedRadioButtonId();
            if (selectedCourseId != -1) {
                if (selectedCourseId == R.id.courseSelectDSRadio)
                    selectedCourse = "D.S";
                else if (selectedCourseId == R.id.courseSelectGLRadio)
                    selectedCourse = "G.L";
                else if (selectedCourseId == R.id.courseSelectIARadio)
                    selectedCourse = "I.A";
                else if (selectedCourseId == R.id.courseSelectIOTRadio)
                    selectedCourse = "I.O.T";
            } else {
                // Toast.makeText(this, "Veuiller sélectionner un parcours.", Toast.LENGTH_SHORT).show();
                showAlertDialogError("Veuiller sélectionner un parcours.");
                return;
            }

            List<String> selectedClubList = new ArrayList<>();

            if (checkboxClub1.isChecked()) selectedClubList.add("Club 1");
            if (checkboxClub2.isChecked()) selectedClubList.add("Club 2");
            if (checkboxClub3.isChecked()) selectedClubList.add("Club 3");
            String selectedClubs = selectedClubList.isEmpty() ? "Aucun club sélectionné" : String.join(" - ", selectedClubList);

            Toast.makeText(this, "Votre parcours a été sélectionné : " + selectedCourse, Toast.LENGTH_SHORT).show();
        });

    }

    private void showAlertDialogError(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Erreur");
        builder.setMessage(message);
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        // builder.setNegativeButton("Annuler", (dialog, which) -> dialog.cancel());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}