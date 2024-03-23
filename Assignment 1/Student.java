
public class Student {
    private int number;
    private String name;
    private String dob; 
    private String degree;
    private String[] codes;
    private int cnt = 0;

    public Student(int number, String name, String dob, String degree){
        this.number = number;
        this.name = name;
        this.dob = dob;
        this.degree = degree;
        this.codes = new String[10];
    }

    public void addCode(String code){
        if(cnt<10){
            codes[cnt] = code;
            cnt++;
        }
    }

    public int getNumber(){
        return number;
    }

    public String toString(){
        String str = "Student Number: "+number+"\nStudent Name: "+name+"\nDate of birth: "+dob+"\nDegree: "+degree+"\nSubjects: ";
        for(int i = 0; i<cnt;i++ ){
            str = str + codes[i] + " " ;
        }

        return str;
    }
}
