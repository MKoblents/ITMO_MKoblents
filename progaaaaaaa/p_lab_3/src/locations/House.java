package locations;

import enym.Material;

import java.util.List;

public record House(List<Room> rooms, int floors, List<Material> materials){}
