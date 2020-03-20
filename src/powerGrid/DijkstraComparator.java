package powerGrid;

import java.util.Comparator;

@SuppressWarnings("hiding")
public class DijkstraComparator implements Comparator<Path> {

	@Override
	public int compare(Path o1, Path o2) {
		// TODO Auto-generated method stub
		return o1.getLength() - o2.getLength();
	}

}
