package temp;

import Teacher;

public class temp {
	public class Teacher {
	private String name;
	private String school;
		public Teacher(String n, String s) {
			name = n;
			school = s;
		}
		public String getName() {return name;}
		public String getSchool() {return school;}
		public void teach() {
			System.out.print("Teach");
		}
	}

	public class HighSchoolTeacher extends Teacher {
		private String[] courseList;
		public HighSchoolTeacher(String n, String s, String[] c) {
			super(n,s);
			courseList = c;
		}
		public void teach() {System.out.print("TEACH ");}
		public String toString() {
			return name + " teaches at " + school;
		}
	}

	public static void main(String[] args) {
		Teacher k = new temp().Teacher("John", "High School");
		System.out.println(k);
		k.teach();
	}
}
