import React from 'react';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { NavigationContainer } from '@react-navigation/native';
import { Ionicons } from '@expo/vector-icons';
import VideogamesScreen from '../screens/VideogamesScreen.js';
import FavoritosScreen from '../screens/FavoritosScreen.js';
import AdicionarScreen from '../screens/AdicionarScreen.js';

const Tab = createBottomTabNavigator();

export default function MainTabs() {
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
