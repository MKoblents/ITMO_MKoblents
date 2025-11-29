package programm;

import pokemons.Leavanny;
import pokemons.Lycanroc;
import pokemons.Spiritomb;
// import pokemons.Swadloon;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;
import pokemons.*;
import java.util.Random;
import static ru.ifmo.se.pokemon.Stat.*;
import static ru.ifmo.se.pokemon.Stat.*;
import static pokemons.Swadloon.*;
public class Programm{
    public static void main(String args []){
        hello();
        Battle b = new Battle();
        Leavanny p1 = new Leavanny("1",1);
        Lycanroc p2 = new Lycanroc("2",36);
        Rockruff p3 = new Rockruff("3", 32);
        Sewaddle p4 =new Sewaddle("4",1);
        Spiritomb p5 = new Spiritomb("5",7);
        //Swadloon p6 = new Swadloon("6",1);
        b.addAlly(p1);
        b.addAlly(p4);
        b.addAlly(p3);
        //b.addFoe(p6);
        b.addFoe(p5);
        b.addFoe(p2);
        b.go();

    }
    public static Integer randomInt(int i){
        Random r = new Random();
        return r.nextInt(i)+1;
    }
}