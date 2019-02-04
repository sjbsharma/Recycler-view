package np.com.sanjibsharma.recyclerday;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TeacherClss teacherClss;
    TeacherAdapter teacherAdapter;
    ArrayList<TeacherClss> arrayList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.rec);

        arrayList.add(new TeacherClss("Rajesh Kamar"));
        arrayList.add(new TeacherClss("saroj Giri"));
        arrayList.add(new TeacherClss("suraj  Tulachan"));
        arrayList.add(new TeacherClss("Anuj sherchan"));
        arrayList.add(new TeacherClss("krishna shreshtha"));

        teacherAdapter = new TeacherAdapter(arrayList);
        recyclerView.setAdapter(teacherAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    public  class  TeacherClss{
        String name;

        public TeacherClss(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }


    }
    public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewholder>{
        ArrayList<TeacherClss> arrayList = new ArrayList<>();

        public TeacherAdapter(ArrayList<TeacherClss> arrayList) {
            this.arrayList = arrayList;
        }

        @NonNull
        @Override
        public TeacherViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View designsupport =getLayoutInflater().inflate(R.layout.single_teacher_view,viewGroup,false);
            TeacherViewholder teacherViewHolder = new TeacherViewholder(designsupport);

            return teacherViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull TeacherViewholder teacherViewholder, int i) {
            teacherViewholder.txtname.setText(arrayList.get(i).getName());


        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class TeacherViewholder extends RecyclerView.ViewHolder{

            TextView txtname;
            public TeacherViewholder(@NonNull View itemView) {
                super(itemView);
                txtname=(TextView)itemView.findViewById(R.id.textView4);
            }
        }
    }
}
