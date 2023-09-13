package org.homework7;

public class BubbleSort {
    public SalesRepresentative[] sortDesc(SalesRepresentative[] salesRep) {
        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < salesRep.length - 1; ++i) {
                if (salesRep[i].salesNr * salesRep[i].quota < salesRep[i+1].salesNr * salesRep[i+1].quota) {
                    isSorted = false;
                    SalesRepresentative aux = salesRep[i];
                    salesRep[i] = salesRep[i+1];
                    salesRep[i+1] = aux;
                }
            }
        }
        return salesRep;
    }
}
