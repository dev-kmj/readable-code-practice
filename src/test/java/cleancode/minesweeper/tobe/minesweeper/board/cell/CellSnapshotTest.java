package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellSnapshotTest {

    @DisplayName("CellSnapshot의 ofEmpty()메서드가 EMPTY 상태를 반환한다.")
    @Test
    void returnEmpty() {

        // when
        CellSnapshot cellSnapshot = CellSnapshot.ofEmpty();

        // then
        assertEquals(CellSnapshotStatus.EMPTY, cellSnapshot.getStatus());
        assertEquals(0, cellSnapshot.getNearbyLandMineCount());
     }

     @DisplayName("NUMBER 상태와 인접한 지뢰의 개수를 반환한다.")
     @Test
     void returnNumber() {
         // given
         int nearbyLandMineCount = 3;

         // when
         CellSnapshot cellSnapshot = CellSnapshot.ofNumber(nearbyLandMineCount);

         // then
         assertEquals(CellSnapshotStatus.NUMBER, cellSnapshot.getStatus());
         assertEquals(nearbyLandMineCount, cellSnapshot.getNearbyLandMineCount());
      }
}
