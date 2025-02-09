package CollectionsConceitos.Comparators;

import CollectionsConceitos.Model.Estudante;

import java.util.Comparator;

public class IdEstudanteComparator implements Comparator<Estudante> {

    @Override
    public int compare(Estudante o1, Estudante o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
