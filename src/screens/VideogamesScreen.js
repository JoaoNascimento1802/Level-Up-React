// App.js

//Tela inicial, onde aparece todos os consoles.
import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { View, Text, StyleSheet, TextInput, TouchableOpacity } from 'react-native';
import { Ionicons } from '@expo/vector-icons';

const Tab = createBottomTabNavigator();

function Header() {
  return (
    <View style={styles.header}>
      <Text style={styles.title}>Level Up</Text>
      <Ionicons name="search" size={20} color="white" />
    </View>
  );
}

function VideogamesScreen() {
  return (
    <View style={styles.screen}>
      <Header />
      <Text style={styles.sectionTitle}>Consoles</Text>
    </View>
  );
}

function FavoritosScreen() {
  return (
    <View style={styles.screen}>
      <Header />
      <Text style={styles.sectionTitle}>Favoritos</Text>
    </View>
  );
}

function AdicionarScreen() {
  return (
    <View style={styles.screen}>
      <Header />
      <Text style={styles.sectionTitle}>Adicionar Console</Text>
    </View>
  );
}

export default function App() {
  return (
    <NavigationContainer>
      <Tab.Navigator
        screenOptions={({ route }) => ({
          tabBarIcon: ({ color, size }) => {
            let iconName;

            if (route.name === 'Videogames') iconName = 'game-controller';
            else if (route.name === 'Favoritos') iconName = 'heart';
            else if (route.name === 'Adicionar') iconName = 'add-circle';

            return <Ionicons name={iconName} size={size} color={color} />;
          },
          tabBarActiveTintColor: 'white',
          tabBarInactiveTintColor: '#999',
          tabBarStyle: {
            backgroundColor: '#30052D',
            borderTopLeftRadius: 20,
            borderTopRightRadius: 20,
          },
          headerShown: false,
        })}
      >
        <Tab.Screen name="Videogames" component={VideogamesScreen} />
        <Tab.Screen name="Favoritos" component={FavoritosScreen} />
        <Tab.Screen name="Adicionar" component={AdicionarScreen} />
      </Tab.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  header: {
    backgroundColor: '#30052D',
    padding: 16,
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    borderBottomRightRadius: 10,
    borderBottomLeftRadius: 10,
  },
  title: {
    color: 'white',
    fontSize: 22,
    fontWeight: 'bold',
    fontFamily: 'monospace',
  },
  screen: {
    flex: 1,
    backgroundColor: '#C3C0BE',
    padding: 20,
  },
  sectionTitle: {
    fontSize: 20,
    fontWeight: 'bold',
    borderBottomWidth: 2,
    borderBottomColor: '#2D1B18',
    color: '#2D1B18',
    fontFamily: 'monospace',
    marginTop: 20,
  },
});
