public class Pokemon_Demo {
    public static void main(String[] args) {
        Pokemon p1 = new Pokemon();
        p1.setName("Pikachu");
        p1.setHP(150);
        p1.setAttackDamage(2);
        p1.setType("Electric");
        p1.setLevel(3);

        Pokemon p2 = new Pokemon();
        p2.setName("Charizard");
        p2.setType("Fire");
        p2.setLevel(4);
        p2.setAttackDamage(4);
        p2.setHP(120);

        int p2attack1 = p2.calculateDamage();
        p1.setHP(p1.getHP() - p2attack1);
        System.out.println(p1.getName() + " now has " + p1.getHP() + " health.");

        while (p1.getHP() >= 0 && p2.getHP() >= 0) {
            p1.attack(p2);
            if (p1.getHP() <= 0)
                break;
            p2.attack(p1);
            if (p1.getHP() <= 0)
                break;
        }
        if(p1.getHP() >= 0){
            System.out.println(p1.getName() + " won!");
        } else if (p2.getHP() >= 0) {
            System.out.println(p2.getName() + " won!");
        }
    }
}
