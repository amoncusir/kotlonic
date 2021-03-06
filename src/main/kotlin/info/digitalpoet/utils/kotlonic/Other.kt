/** <!-- Documentation for: info.digitalpoet.utils.kotlonic.Other on 16/05/2017 -->
 *
 * @author Aran Moncusí Ramírez
 */
package info.digitalpoet.utils.kotlonic

//~ Constants ==========================================================================================================

//~ Functions ==========================================================================================================

//~ Extensions =========================================================================================================

inline fun <T, R> T.each(init: (T) -> R?, predicate: (T, R?) -> Boolean, body: (T, R?) -> R?): R?
{
    var i: R? = init(this)
    while (predicate(this, i)) i = body(this, i)
    return i
}

inline fun <T, E> T.eachWith(col: Iterable<E>, fn: T.(E) -> Unit): T
{
    for (value in col) this.fn(value)
    return this
}

inline fun <T> T.supposing(condition: (T) -> Boolean): T? = if (condition(this)) this else null

//~ Annotations ========================================================================================================

//~ Interfaces =========================================================================================================

//~ Enums ==============================================================================================================

//~ Data Classes =======================================================================================================

//~ Classes ============================================================================================================

//~ Sealed Classes =====================================================================================================

//~ Objects ============================================================================================================
