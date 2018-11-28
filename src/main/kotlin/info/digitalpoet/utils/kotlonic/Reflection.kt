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
    val prop = c.kotlin.allProperties().filter { it.name == name }.firstOrNull()!!
    return prop as KProperty<R>
}

//~ Extensions =========================================================================================================

/**
 *  Get all members, include superclass members (inherited)
 */
fun KClass<*>.allMembers(): List<KCallable<*>> =
    this.members or this.allSuperclasses.map { it.members }.reduce { acc, next -> acc or next }

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
