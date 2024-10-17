package cleancode.minesweeper.tobe.minesweeper.board;

import cleancode.minesweeper.tobe.minesweeper.board.position.CellPosition;
import cleancode.minesweeper.tobe.minesweeper.gamelevel.Beginner;
import cleancode.minesweeper.tobe.minesweeper.gamelevel.GameLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    private GameBoard gameBoard;

    @BeforeEach
    void setUpBeginnerBoard() {
        gameBoard = new GameBoard(new Beginner());
    }

    @DisplayName("Beginner 레벨의 게임을 초기화하여 빈 셀과 지뢰를 설정한다.")
    @Test
    void InitializeBeginnerGameAndSet() {
        // given
        gameBoard.initializeGame();

        // when

        // then
        assertEquals(8, gameBoard.getRowSize());
        assertEquals(10, gameBoard.getColSize());
     }


     @DisplayName("지뢰 셀을 열면 게임 상태가 패배로 변경된다.")
     @Test
     void openLandMineCell() {
         // given
         GameLevel gameLevel = new GameLevel() {
             @Override
             public int getRowSize() {
                 return 1;
             }

             @Override
             public int getColSize() {
                 return 1;
             }

             @Override
             public int getLandMineCount() {
                 return 1;
             }
         };

         gameBoard = new GameBoard(gameLevel);
         gameBoard.initializeGame();

         CellPosition landMinePosition = new CellPosition(0, 0);

         // when
         gameBoard.openAt(landMinePosition);

         // then
         assertTrue(gameBoard.isLoseStatus());
      }

      @DisplayName("빈 셀을 열면 게임 상태는 진행 중으로 유지된다.")
      @Test
      void openEmptyCell() {
          // given
          GameLevel gameLevel = new GameLevel() {
              @Override
              public int getRowSize() {
                  return 2; // 2행
              }

              @Override
              public int getColSize() {
                  return 2; // 2열
              }

              @Override
              public int getLandMineCount() {
                  return 0; // 지뢰 없음
              }
          };

          gameBoard = new GameBoard(gameLevel); // 테스트용 게임 보드 생성
          gameBoard.initializeGame(); // 게임 초기화

          CellPosition emptyCellPosition = new CellPosition(1, 1);

          // when
          gameBoard.openAt(emptyCellPosition);

          // then
          assertTrue(gameBoard.isInProgress());
       }
}
