import java.io.*;

/*
JavaRush. Java Core. Уровень 20. Лекция 7. (2011)

Externalizable для апартаментов

Реализуй интерфейс Externalizable в классе Apartment.
*/

public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }

        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        public void readExternal(ObjectInput in) throws ClassNotFoundException, IOException {
            address = (String) in.readObject();
            year = in.readInt();
        }
    }

    public static void main(String[] args) {

    }
}
