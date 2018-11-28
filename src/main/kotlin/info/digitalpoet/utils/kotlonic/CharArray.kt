/** <!-- Documentation for: info.digitalpoet.utils.spring.utils.CharArray on 17/05/2017 -->
 *
 * @author Aran Moncusí Ramírez
 */
@file:JvmName("StringUtils")
package info.digitalpoet.utils.kotlonic

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

//~ Constants ==========================================================================================================

internal val REGEX_NONE_ALPHA: Regex = "[\\p{Punct}\\p{Space}\\p{Blank}\\p{Cntrl}]+".toRegex()

//~ Functions ==========================================================================================================

//~ Extensions =========================================================================================================

fun CharSequence.replaceNoneAlpha(replace: String): String
        = this.replace(REGEX_NONE_ALPHA, replace)

fun CharSequence.safeSubstring(range: IntRange): String =
        if(this.length > range.last) this.substring(range) else this.toString()

fun CharSequence.capitalizeWords(): String =
        this.replace("[^\\p{Punct}\\d\\p{Space}]+".toRegex()) { m -> m.value.capitalize() }

fun CharSequence.toCamelCase(): String =
        this
            .trim()
            .capitalizeWords()
            .replaceNoneAlpha("")

fun CharSequence.toUnderscoreCase(): String =
        this.toCamelCase()
            .decapitalize()
            .map { if(it.isUpperCase()) "_" + it.toLowerCase() else it.toString() }
            .reduce { acc, c -> acc + c }

fun CharSequence.splitByStep(range: IntProgression): List<String>
{
    val spliced = this.subSequence(range.first, range.last)
    return (range.step..range.last step range.step).map { spliced.substring(it - range.step, it) }
}

fun CharSequence.splitByStep(step: Int): List<String> = this.splitByStep(0..this.length step step)

fun CharSequence.toDate(format: String = "yyyy-MM-dd HH:mm:ss"): Date
        = SimpleDateFormat(format, Locale.ROOT).parse(this.toString())

//~ Operators ==========================================================================================================

infix operator fun String.times(b: Int): String = (1..b).map { this }.reduce { acc, s -> acc + s }

//~ Annotations ========================================================================================================

//~ Interfaces =========================================================================================================

//~ Enums ==============================================================================================================

//~ Data Classes =======================================================================================================

//~ Classes ============================================================================================================

//~ Sealed Classes =====================================================================================================

//~ Objects ============================================================================================================
