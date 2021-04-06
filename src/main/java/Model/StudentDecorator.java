package Model;

import java.util.Base64;

public class StudentDecorator extends Student {

    public StudentDecorator(String name, int course, int id, float avg_mark, boolean budget_basis) {
        super(encode(name), course, id, avg_mark, budget_basis);
    }

    public String getName() {
        return decode(super.getName());
    }

    public void setName(String name) {
        super.setName(encode(name));
    }


    private static String encode(String data) {
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    private static String decode(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }
}


