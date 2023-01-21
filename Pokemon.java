public class Pokemon {
    private String Name, Type;
    private int Level, HP, attackDamage;

    public void Pokemon()
    {
        Name = "default";
        
    }

//Accessors
    public String getName()
    {
        return Name;
    }
    public String getType()
    {
        return Type;
    }
    public int getLevel()
    {
        return Level;
    }
    public int getHP(){return HP;}
    public int getAttackDamage(){return attackDamage;}

//Mutators
    public void setName(String newName)
    {
        Name = newName;
    }
    public void setType(String newType){Type = newType;}
    public void setLevel(int newLevel)
    {
        if (newLevel >= 0)
        {
            Level = newLevel;
        }
    }
    public void setHP(int newHP)
    {
        HP = newHP;
    }
    public void setAttackDamage(int newattackDamage)
    {
        if (newattackDamage > 0)
        {
            attackDamage = newattackDamage;
        }
        else
        {
            System.out.println("No negative attack damage.");
            System.exit(0);
        }
    }
    public int calculateDamage()
    {
        int random1to6 = (int)(Math.random() * 6) + 1;
        int Damage = attackDamage * (random1to6);
        return Damage;
    }
    public boolean equals(Pokemon otherPokemon)
    {
        boolean areEqual = this.Name.equals(otherPokemon.Name) &&
                this.Level == otherPokemon.Level &&
                this.Type.equals(otherPokemon.Type) &&
                this.attackDamage ==otherPokemon.attackDamage &&
                this.HP == otherPokemon.HP;
        return areEqual;
    }

    public void attack(Pokemon otherPokemon)
    {
        int damageDealt = this.calculateDamage();
        System.out.println(this.Name + " attacks " + damageDealt + " " + Type + " damage.");
        otherPokemon.HP = otherPokemon.HP - damageDealt;
        if (otherPokemon.HP <= 0)
        {
            otherPokemon.HP = 0;
        }
        System.out.println(otherPokemon.Name + " now has " + otherPokemon.HP + " hit points left.");
    }
}
