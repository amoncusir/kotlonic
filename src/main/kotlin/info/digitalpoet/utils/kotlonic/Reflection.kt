@file:JvmName("ReflectionUtils")

/** <!-- Documentation for: info.digitalpoet.utils.spring.utils.Reflection on 17/05/2017 -->
 *
 * @author Aran Moncusí Ramírez
 */
package info.digitalpoet.utils.kotlonic

import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.full.allSuperclasses

//~ Constants ==========================================================================================================

//~ Functions ==========================================================================================================

@Suppress("UNCHECKED_CAST")
fun <R> getKPropertyFromJavaProperty(c: Class<*>, name: String): KProperty<R>
{
    val prop = c.kotlin.allProperties().firstOrNull { it.name == name }!!
    return prop as KProperty<R>
}

//~ Extensions =========================================================================================================

/**
 *  Get all members, include superclass members (inherited)
 */
fun KClass<*>.allMembers(): List<KCallable<*>> =
    (members or allSuperclasses
        .map { it.members }
        .reduce { acc: Iterable<KCallable<*>>, collection: Collection<KCallable<*>> -> acc or collection })
        .toList()

/**
 * Get all members, and filter by Property
 */
@Suppress("UNCHECKED_CAST")
fun KClass<*>.allProperties() = this.allMembers().filter { it is KProperty<*> } as List<KProperty<*>>

//~ Annotations ========================================================================================================

//~ Interfaces =========================================================================================================

//~ Enums ==============================================================================================================

//~ Data Classes =======================================================================================================

//~ Classes ============================================================================================================

//~ Sealed Classes =====================================================================================================

//~ Objects ============================================================================================================
