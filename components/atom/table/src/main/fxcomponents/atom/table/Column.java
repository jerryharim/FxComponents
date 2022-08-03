package relia.arsf.component.atom.table;


/**
 * Column for the table component.
 * It associate the column name with the property name
 */
public class Column {
    private final int rank; 
    private final String column_name, property_name;

    public Column(int rank, String column_name, String property_name) {
        this.rank = rank; 
        this.column_name = column_name;
        this.property_name = property_name;
    }

    // getters

	public int getRank() {
		return rank;
	}

    public String getColumn_name() {
        return column_name;
    }

    public String getProperty_name() {
        return property_name;
    }

}
