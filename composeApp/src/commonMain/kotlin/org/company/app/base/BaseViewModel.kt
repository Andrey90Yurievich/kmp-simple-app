package org.company.app.base

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow


//Класс BaseViewModel использует параметр State
//Можно одновременно использовать несколько параметров:
//параметры могут представлять один и тот же тип, а могут представлять и разные типы.
public abstract class BaseViewModel<State : Any, Action, Event>(initialState: State) : ViewModel() { //Параметры класса указываются после имени класса в угловых скобках.
  //типы объектов параметризированы, то есть указать, какой тип будет передаваться через параметр State:
   //первичный конструктор принимает данные извне через параметр initialState
    private  val _viewStates = MutableStateFlow(initialState)
    private val _viewActions = MutableSharedFlow<Action?>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    //replay: количество значений, воспроизводимых новым подписчикам, onBufferOverflow: настраивает действие отправки при переполнении буфера.

    public fun viewStates(): StateFlow<State> = _viewStates.asStateFlow()
    public fun viewActions(): SharedFlow<Action?> = _viewActions.asSharedFlow()

    protected var viewState: State
        get() = _viewStates.value //управляет получением значения свойства
        set(value) { // определяет логику установки значения переменной.
        _viewStates.value = value
        }

    protected var viewAction: Action?
        get() = _viewActions.replayCache.last()
        set(value) {
            _viewActions.tryEmit(value) //Пытается передать значение в этот общий поток без приостановки. Возвращает, trueесли значение было передано успешно
        }
    public abstract fun obtainEvent(viewEvent: Event)
    public fun clearAction() {
        viewAction = null
    }
}