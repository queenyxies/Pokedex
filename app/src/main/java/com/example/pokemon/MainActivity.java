package com.example.pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView name, id, hp, type, att, def, sa, sd, spd;
    LinearLayout ll, lldet;
    ImageView img, sbt;
    ImageButton cbt;
    ProgressBar pbhp, pbatt, pbdef, pbsa, pbsd, pbspd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        in();
        fnctn();
    }

    private void in() {
        //EditText
        et = findViewById(R.id.et);

        //Button
        sbt = findViewById(R.id.sbt);
        cbt = findViewById(R.id.cbt);

        //ImageView
        img = findViewById(R.id.img);

        //TextViews
        name = findViewById(R.id.name);
        id = findViewById(R.id.id);
        type = findViewById(R.id.type);
        pbhp = findViewById(R.id.pbhp);
        hp = findViewById(R.id.hp);
        att = findViewById(R.id.att);
        pbatt = findViewById(R.id.pbatt);
        def = findViewById(R.id.def);
        pbdef = findViewById(R.id.pbdef);
        sa = findViewById(R.id.sa);
        pbsa = findViewById(R.id.pbsa);
        sd = findViewById(R.id.sd);
        pbsd = findViewById(R.id.pbsd);
        spd = findViewById(R.id.spd);
        pbspd = findViewById(R.id.pbspd);
        ll = findViewById(R.id.ll);
        lldet = findViewById(R.id.lldet);

    }

    private void fnctn() {
        sbt.setOnClickListener(view -> {
            String txt = et.getText().toString().toLowerCase();
            String url = "https://pokeapi.co/api/v2/pokemon/" + txt;

            RequestQueue q = Volley.newRequestQueue(this);
            q.start();

            JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET,url,null,
                    response -> {
                        try {
                            et.setText(null);

                            //Name
                            JSONArray n = response.getJSONArray("forms");
                            JSONObject n2 = n.getJSONObject(0);
                            String nm = n2.getString("name");
                            name.setText(nm.substring(0, 1).toUpperCase() + nm.substring(1));

                            //ID
                            String ai = response.getString("id");
                            id.setText(ai);

                            //Img
                            String im = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/" + ai + ".png";
                            img.setBackground(null);

                            img.setVisibility(View.VISIBLE);
                            Picasso.get().load(im).into(img);
                            lldet.setPadding(0,0,0,0);

                            //Type
                            JSONArray t = response.getJSONArray("types");
                            JSONObject t2 = t.getJSONObject(0);
                            JSONObject t3 = t2.getJSONObject("type");
                            String atype = t3.getString("name");
                            type.setText(atype.substring(0, 1).toUpperCase() + atype.substring(1));




                            if(atype.equals("normal")){
                                ll.setBackground(null);
                                ll.setBackground(getResources().getDrawable(R.drawable.normal));

                                cbt.setImageResource(R.drawable.znormal_bg);
                                type.setTextColor(Color.parseColor("#C6DBE0"));

                                //PROGRESS BAR COLOR CHANGE VALUE EACH TYPE
                                pbhp.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#B0E5E5F5")));
                                pbatt.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#B0E5E5F5")));
                                pbdef.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#B0E5E5F5")));
                                pbsa.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#B0E5E5F5")));
                                pbsd.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#B0E5E5F5")));
                                pbspd.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#B0E5E5F5")));
                            }




                            else if(atype.equals("fire")){
                                ll.setBackground(null);
                                ll.setBackground(getResources().getDrawable(R.drawable.fire));

                                cbt.setImageResource(R.drawable.zfire_bg);
                                type.setTextColor(Color.parseColor("#FEA858"));

                                //PROGRESS BAR COLOR CHANGE VALUE EACH TYPE
                                pbhp.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#C04000")));
                                pbatt.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#C04000")));
                                pbdef.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#C04000")));
                                pbsa.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#C04000")));
                                pbsd.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#C04000")));
                                pbspd.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#C04000")));
                            }





                            else if(atype.equals("grass")){
                                ll.setBackground(null);
                                ll.setBackground(getResources().getDrawable(R.drawable.grass));

                                cbt.setImageResource(R.drawable.zgrass_bg);
                                type.setTextColor(Color.parseColor("#BFFFC7"));

                                //PROGRESS BAR COLOR CHANGE VALUE EACH TYPE
                                pbhp.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#50C878")));
                                pbatt.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#50C878")));
                                pbdef.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#50C878")));
                                pbsa.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#50C878")));
                                pbsd.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#50C878")));
                                pbspd.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#50C878")));
                            }



                            else if(atype.equals("poison")){
                                ll.setBackground(null);
                                ll.setBackground(getResources().getDrawable(R.drawable.poison));

                                cbt.setImageResource(R.drawable.zpoison_bg);
                                type.setTextColor(Color.parseColor("#BB73E0"));

                                //PROGRESS BAR COLOR CHANGE VALUE EACH TYPE
                                pbhp.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#BF40BF")));
                                pbatt.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#BF40BF")));
                                pbdef.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#BF40BF")));
                                pbsa.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#BF40BF")));
                                pbsd.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#BF40BF")));
                                pbspd.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#BF40BF")));
                            }




                            else{
                                ll.setBackground(null);
                                ll.setBackground(getResources().getDrawable(R.drawable.normal));

                                type.setTextColor(Color.parseColor("#C6DBE0"));
                                cbt.setImageResource(R.drawable.znormal_bg);

                                //PROGRESS BAR COLOR CHANGE VALUE EACH TYPE
                                pbhp.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#B0E5E5F5")));
                                pbatt.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#B0E5E5F5")));
                                pbdef.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#B0E5E5F5")));
                                pbsa.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#B0E5E5F5")));
                                pbsd.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#B0E5E5F5")));
                                pbspd.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#B0E5E5F5")));
                            }


                            //Array for HP, Attack, Defense, Special-Attack, Special-Defense, Speed
                            JSONArray array = response.getJSONArray("stats");

                            //HP = A
                            JSONObject a = array.getJSONObject(0);
                            String ahp = a.getString("base_stat");
                            int aa = Integer.parseInt(ahp);

                            hp.setText(ahp);
                            pbhp.setProgress(aa);


                            //Attack = B
                            JSONObject b = array.getJSONObject(1);
                            String batt = b.getString("base_stat");
                            int bb = Integer.parseInt(batt);

                            att.setText(batt);
                            pbatt.setProgress(bb);


                            //Defense = C
                            JSONObject c = array.getJSONObject(2);
                            String cdef = c.getString("base_stat");
                            int cc = Integer.parseInt(ahp);

                            def.setText(cdef);
                            pbdef.setProgress(cc);

                            //Special-Attack = D
                            JSONObject d = array.getJSONObject(3);
                            String dsa = d.getString("base_stat");
                            int dd = Integer.parseInt(ahp);

                            sa.setText(dsa);
                            pbsa.setProgress(dd);


                            //Special-Defense = E
                            JSONObject e = array.getJSONObject(4);
                            String esd = e.getString("base_stat");
                            int ee = Integer.parseInt(esd);

                            sd.setText(esd);
                            pbsd.setProgress(ee);


                            //Speed = F
                            JSONObject f = array.getJSONObject(5);
                            String fspd = f.getString("base_stat");
                            int ff = Integer.parseInt(fspd);

                            spd.setText(fspd);
                            pbspd.setProgress(ff);

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    },
                    error -> {
                        Dialog dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);
                        dialog.setCancelable(false);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                        dialog.setContentView(R.layout.dialog);

                        Button dialogButton = (Button) dialog.findViewById(R.id.ok_btn);
                        dialogButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                        dialog.show();

                    });
            q.add(req);
    });


        cbt.setOnClickListener(v -> {



            String n = "null";

            et.setText(null);
            cbt.setImageResource(R.drawable.znormal_bg);
            img.setVisibility(View.GONE);
            ll.setBackground(null);
            ll.setBackground(getResources().getDrawable(R.drawable.ash));
            Picasso.get().load(n).into(img);
            name.setText("Name");
            id.setText("Index ID");
            type.setText("Type");
            type.setTextColor(Color.parseColor("#C6DBE0"));
            hp.setText(null);
            pbhp.setProgress(0);
            att.setText(null);
            pbatt.setProgress(0);
            def.setText(null);
            pbdef.setProgress(0);
            sa.setText(null);
            pbsa.setProgress(0);
            sd.setText(null);
            pbsd.setProgress(0);
            spd.setText(null);
            pbspd.setProgress(0);
            lldet.setPadding(0,550,0,0);
        });

        // FIRE - Charmander
        // POISON - Arbok
        // NORMAL - Snorlax
        // GRASS - Bulbasaur

}
}
