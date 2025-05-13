import React, { useState } from 'react';
import { Button, View } from 'react-native';
import ConsoleModal from '../components/modal/ConsoleModal';

export default function AdicionarScreen() {
  const [modalVisible, setModalVisible] = useState(false);

  return (
    <View style={{ flex: 1, backgroundColor: '#C3C0BE', padding: 20 }}>
      <Button title="Abrir Modal" onPress={() => setModalVisible(true)} />
      <ConsoleModal
        visible={modalVisible}
        onClose={() => setModalVisible(false)}
        onSubmit={(data) => {
          console.log('Console adicionado:', data);
        }}
      />
    </View>
  );
}
