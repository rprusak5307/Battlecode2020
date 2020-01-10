package sprint;

import java.util.Arrays;
import java.util.Comparator;

public class MinePatchMessage extends Message {

    Message m;
    final int mpmSchema = 2; //MinePatchMessages are message type 1
    int numPatches;
    int numPatchesLeft;

    public MinePatchMessage(int myMapHeight, int myMapWidth, int myTeam) {
        m = new Message(myMapHeight, myMapWidth, myTeam);
        m.writeSchema(mpmSchema);
        numPatches = m.getBitsRemaining()/12;
        numPatchesLeft = numPatches;
    }

    boolean writePatch(int tile, int weight) {
        if(numPatchesLeft>0) {
            if(writeToArray(tile, 6) && writeToArray(weight, 6)) {
                numPatchesLeft-=1;
                return true;
            }
        }
        return false;
    }

}
