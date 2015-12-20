/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.unice.polytech.qgl.qae.map;

import fr.unice.polytech.qgl.qae.actions.withparams.Direction;
import fr.unice.polytech.qgl.qae.actions.withparams.Heading;
import fr.unice.polytech.qgl.qae.exceptions.MapExeption;
import fr.unice.polytech.qgl.qae.map.geometry.Coordinates;
import fr.unice.polytech.qgl.qae.map.geometry.Vect;
import fr.unice.polytech.qgl.qae.map.geometry.Vect2D;

import java.util.ArrayList;
import java.util.HashMap;
import fr.unice.polytech.qgl.qae.map.tile.Creek;
import fr.unice.polytech.qgl.qae.map.tile.FlyTile;

/**
 * Classe Map permettant de stocker les informations sur les cases et les
 * organiser selon un repère en 2D
 *
 * @author user
 */
public class Map {

    private final HashMap<Coordinates, FlyTile> map;

    private final ArrayList<Coordinates> coordinates;

    /**
     * Contient une hashmap pour contenir toutes les cases de la map. s
     *
     * @param origin case origine de l'explorer
     */
    public Map(FlyTile origin) {
        map = new HashMap<>();
        coordinates = new ArrayList<>();
        put(new Coordinates(0, 0), origin);
    }

    /**
     * Met à jour une case déja explorée
     *
     * @param c
     * @param t
     */
    public void maj(Coordinates c, FlyTile t) {

        coordinates.stream().filter((cc) -> (cc.equals(c))).forEach((cc) -> map.replace(cc, t));
        put(c, t);

    }

    /**
     * Ajoute une case dans la map si elle est absente
     *
     * @param c
     * @param t
     */
    public final void put(Coordinates c, FlyTile t) {
        map.putIfAbsent(c, t);
        coordinates.add(c);
    }

    public Direction chooseDirEcho(Direction dir) {
        if (coordinates.get(0).distance(coordinates.get(1)) > coordinates.get(0).distance(coordinates.get(2))) {
            return dir.left();
        } else {
            return dir.right();
        }
    }

    public void printCoordinates() {
        coordinates.stream().forEach((coordinate) -> System.out.println("X : " + coordinate.getX() + " Y = " + coordinate.getY()));
    }

    /**
     * renvoie true si la coordonnée a déja été explorée
     *
     * @param c
     * @return
     */
    public boolean have_coord(Coordinates c) {
        return coordinates.stream().anyMatch((coordinate) -> (c.equals(coordinate)));
    }

    public Direction best_dir(Direction d) {
        int dist1 = coordinates.get(0).distance(coordinates.get(1));
        int dist2 = coordinates.get(0).distance(coordinates.get(2));
        if (dist1 > dist2) {
            return d.left();
        } else {
            return d.right();
        }
    }


    /**
     *
     * @return true si la dernière coordonnée a un biome de type océan
     */
    public boolean last_is_only_ocean() {
        FlyTile t = map.get(coordinates.get(coordinates.size() - 1));
        return t.have_biome(BiomeType.OCEAN)  && t.nb_biomes()==1;
    }

    /**
     *
     * @return true si les trois derières coordonnées ont des biomes de type
     * océan
     */
    public boolean three_last_are_ocean() {

        FlyTile t1 = map.get(coordinates.get(coordinates.size() - 2));
        FlyTile t2 = map.get(coordinates.get(coordinates.size() - 2));
        FlyTile t3 = map.get(coordinates.get(coordinates.size() - 3));
        return t1.have_biome(BiomeType.OCEAN)
                && t2.have_biome(BiomeType.OCEAN)
                && t3.have_biome(BiomeType.OCEAN);

    }

    public boolean three_last_are_ground() {

        FlyTile t = map.get(coordinates.get(coordinates.size() - 2));
        FlyTile tt = map.get(coordinates.get(coordinates.size() - 3));
        FlyTile ttt = map.get(coordinates.get(coordinates.size() - 3));

        return (!t.have_biome(BiomeType.OCEAN)) && (!tt.have_biome(BiomeType.OCEAN)) && (!ttt.have_biome(BiomeType.OCEAN));

    }

    
    public boolean five_last_are_ocean() {
        if (coordinates.size() < 5) {
            return false;
        } 
        for (int i = 0; i < 5; i++) {
            if (!map.get(coordinates.get(coordinates.size() - i - 1)).have_only(BiomeType.OCEAN)) {
                return false;
            }
        }
        return true;
    }
    

    public boolean ten_last_are_ocean() {
        if (coordinates.size() < 10) {
            return false;
        } 
        for (int i = 0; i < 10; i++) {
            if (!map.get(coordinates.get(coordinates.size() - i - 1)).have_biome(BiomeType.OCEAN)) {
                return false;
            }
        }
        return true;
    }

    public boolean last_have_creek() {
        FlyTile f =  map.get(coordinates.get(coordinates.size()-1));
        System.out.println(f);
        return f.havecreeks();
    }



    public Creek getlast_creek() {
        if(last_have_creek()) {
            FlyTile t =map.get(coordinates.get(coordinates.size()-1));
            return t.getCreeks().get(0);
        } else {
            throw new MapExeption("add");
        }
    }
    

    /**
     * Met à jour les coordonnée en fonction de turnaround
     *
     * @param c_curent
     * @param d
     * @return
     */
    // TODO: Enlever ça et le metre dans la classe turnaround
    public Coordinates maj_turnaround(Coordinates c_curent, Direction d) {
        switch (d) {
            case E:
                return new Coordinates(c_curent.getX(), c_curent.getY() + 2);
            case W:
                return new Coordinates(c_curent.getX(), c_curent.getY() - 2);
            case S:
                return new Coordinates(c_curent.getX() + 2, c_curent.getY());
            default:
                return new Coordinates(c_curent.getX() - 2, c_curent.getY());
        }
    }

    /**
     * renvoie true si la coordonnée a déja été explorée
     *
     * @param c
     * @return
     */
    // TODO : (already_here and have) => TWO FUNCTION SAME USE STUPID MONKEY 
    public boolean already_here(Coordinates c) {
        return coordinates.stream().anyMatch((cc) -> (cc.equals(c)));
    }

    /**
     *
     * @return true si la carte a trouvé une terre
     */
    public boolean have_ground() {
        return coordinates.stream().anyMatch((coordinate) -> (map.get(coordinate).getT() == Type.GROUND));
    }

    /**
     *
     * @return return la premiere case ground qu'il trouve dans la liste
     */
    // TODO : retourner la case avec la distance minimal !
    public Coordinates getfirstground() {
        for (Coordinates coordinate : coordinates) {
            if (map.get(coordinate).getT() == Type.GROUND) {
                return coordinate;
            }
        }
        return new Coordinates(0, 0);
    }

    /**
     * Return la direction pour se diriger vers le ground
     *
     * @param current
     * @return
     */
    public Direction go_ground(Coordinates current) {
        for (Coordinates coordinate : coordinates) {
            if (map.get(coordinate).getT() == Type.GROUND) {
                if (current.equals(coordinate)) {
                    throw new MapExeption("Coordonnées égales !");
                }

                Vect2D v = new Vect2D(current, coordinate);

                Vect v1 = v.getV_x();
                Vect v2 = v.getV_y();

                if (v1.getValeur() > 1) {
                    return v1.getD();
                } else {
                    return v2.getD();
                }
            }
        }

        throw new MapExeption("Coordonnées GROUND non trouvé !");
    }

    /**
     * Obtenir la dernière Coordonnée ajouté
     *
     * @return
     */
    public Coordinates get_lastcoordinate() {
        return coordinates.get(coordinates.size() - 1);
    }

    public Coordinates get_coordinate(int i) {
        return coordinates.get(i);
    }

    /**
     * Renvoie la case si elle existe
     *
     * @param c2
     * @return
     */
    public FlyTile getFlyTile(Coordinates c2) {

        for (Coordinates c : coordinates) {
            if (c.equals(c2)) {
                return map.get(c);
            }
        }
        return map.get(new Coordinates(0, 0));
    }

    /**
     *
     * @return
     */
    public boolean groundpath() {
        Coordinates last = coordinates.get(coordinates.size() - 1);
        Coordinates soon = coordinates.get(coordinates.size() - 2);

        return map.get(last).getT()
                == Type.GROUND
                && Type.GROUND
                == map.get(soon).getT();
    }

    /**
     *
     * @return
     */
    public Coordinates getMaxCord() {
        int max_x = -1;
        int max_y = -1;
        for (Coordinates coordinate : coordinates) {
            if (coordinate.getX() > max_x) {
                max_x = coordinate.getX();
            }
            if (coordinate.getY() > max_y) {
                max_y = coordinate.getY();
            }
        }

        return new Coordinates(max_x, max_y);
    }

    /**
     *
     * @return
     */
    public Coordinates getMinCord() {
        int min_x = 1000;
        int min_y = 1000;
        for (Coordinates coordinate : coordinates) {
            if (coordinate.getX() < min_x) {
                min_x = coordinate.getX();
            }
            if (coordinate.getY() < min_y) {
                min_y = coordinate.getY();
            }
        }
        return new Coordinates(min_x, min_y);
    }

    // Combien de case disponible jusqu'a out of range a partir de notre coordonnée
    /**
     *
     * @param c
     * @param h
     * @return
     */
    public int getMaxXCord(Coordinates c, Heading h) {
        return 0;
    }

}
