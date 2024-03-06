import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("user_preferences")

class preferences(context: Context) {

    private val dataStore = context.dataStore

    companion object {
        val USER_NAME_KEY = stringPreferencesKey("user_name")
        val MOSTRAR_INTRODUCCION_KEY = booleanPreferencesKey("mostrar_introduccion")
    }

    suspend fun saveUserName(userName: String) {
        dataStore.edit { preferences ->
            preferences[USER_NAME_KEY] = userName
        }
    }

    val userNameFlow: Flow<String?> = dataStore.data.map { preferences ->
        preferences[USER_NAME_KEY]
    }

    // Función para guardar el estado del CheckBox
    suspend fun saveMostrarIntroduccion(mostrar: Boolean) {
        dataStore.edit { preferences ->
            preferences[MOSTRAR_INTRODUCCION_KEY] = mostrar
        }
    }

    // Función para recuperar el estado del CheckBox
    val mostrarIntroduccionFlow: Flow<Boolean?> = dataStore.data.map { preferences ->
        preferences[MOSTRAR_INTRODUCCION_KEY]
    }
}
