package HW_1_OOP_Recap_attached_files;
public class Test {
    public static void main(String[] args) {
        Mars mars = new Mars(100.00);
        Neptune neptune = new Neptune(100.00);
        Saturn saturn = new Saturn(100.00);
        System.out.println("<-- Exchanges -->");
        mars.exchange(saturn, 25.0);
        neptune.exchange(saturn, 10.0);
        saturn.exchange(mars, 122.0);
        saturn.exchange(mars, 121.0);
    }
}
