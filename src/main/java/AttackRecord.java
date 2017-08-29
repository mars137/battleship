/**
 * Created by hadoop-user on 8/29/17.
 */
public class AttackRecord {
    private boolean[][] record;

    public AttackRecord()
    /**
     * Creates a new AttackRecord.
     *
     * The array is 10x10.
     */
    {
        record = new boolean[10][10];
    }

    public void addAttack(Coordinates c)
    /**
     * Adds an attack to the array.
     * The value is changed from false to true.
     */
    {
        record[c.getX()][c.getY()] = true;
    }

    public boolean isRedundant(int x, int y)
    /**
     * Determines whether the attack has already been made.
      @return record[x][y] Returns true if this location
     * on the grid has already been attacked before.
     */
    {
        return record[x][y];
    }

}