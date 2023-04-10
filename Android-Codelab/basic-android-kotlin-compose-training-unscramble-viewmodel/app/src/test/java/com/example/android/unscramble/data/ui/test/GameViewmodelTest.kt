package com.example.android.unscramble.data.ui.test

import com.example.android.unscramble.data.SCORE_INCREASE
import com.example.android.unscramble.data.getUnscrambledWord
import com.example.android.unscramble.ui.GameViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse

import org.junit.Test

class GameViewmodelTest {
    private val viewModel = GameViewModel()

    // 成功パス
    @Test
    fun gameViewModel_CorrectWordguessed_ScoreUpdateAndErrorFlagUnset() { // 3
        var currentGameUiState = viewModel.uiState.value //4
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord) // 5

        viewModel.updateUserGuess(correctPlayerWord) // 6
        viewModel.checkUserGuess() // 6

        currentGameUiState = viewModel.uiState.value //7

        // Assert that checkUserGuess() method updates isGuessedWordWrong is updated correctly //8
        assertFalse(currentGameUiState.isGuessedWordWrong) //8
        // Assert that score is updated correctly //8
        assertEquals(SCORE_AFTER_FIRST_CORRECT_ANSWER, currentGameUiState.score) //8
    }

    companion object {
        private const val SCORE_AFTER_FIRST_CORRECT_ANSWER = SCORE_INCREASE
    }
}
