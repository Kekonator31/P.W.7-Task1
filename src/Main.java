import java.security.Permissions;
import java.util.BitSet;

class permissions{
    public void view_permissions(BitSet user){

        if (user.get(0)) {
            System.out.print("View");
        }
        if (user.get(1)) {
            System.out.print(", Edit");
        }
        if (user.get(2)) {
            System.out.print(", Delete");
        }
        if (user.get(3)) {
            System.out.print(", Change permissions");
        }

        System.out.print(".");
    }

    public String check_permissions(BitSet user, int permissions){
        if (user.get(permissions)) {
            return "does";
        }
        else {
            return "does not";
        }
    }

    public BitSet give_admin(){
        BitSet admin = new BitSet();
        admin.set(0);
        admin.set(1);
        admin.set(2);
        admin.set(3);
        return admin;
    }

    public BitSet give_editor(){
        BitSet editor = new BitSet();
        editor.set(0);
        editor.set(1);
        return editor;
    }

    public BitSet give_reader(){
        BitSet reader = new BitSet();
        reader.set(0);
        return reader;
    }

}

public class Main {
    public static void main(String[] args) {

        permissions p = new permissions();

        BitSet admin = new BitSet();
        BitSet editor = new BitSet();
        BitSet reader = new BitSet();

        admin = p.give_admin();
        editor = p.give_editor();
        reader = p.give_reader();

        System.out.print("User \"admin\" have right to: "); p.view_permissions(admin);
        System.out.println();
        System.out.print("User \"editor\" have right to: "); p.view_permissions(editor);
        System.out.println();
        System.out.print("User \"reader\" have right to: "); p.view_permissions(reader);
        System.out.println();
        System.out.println();

        System.out.println("User \"editor\" " + p.check_permissions(editor, 3) + " to delete files.");

        reader = p.give_admin();

        System.out.print("User \"reader\" have right to: "); p.view_permissions(reader);
    }
}