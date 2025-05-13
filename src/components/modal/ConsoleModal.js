import React, { useState } from 'react';
import { Modal, View, Text, TextInput, TouchableOpacity, StyleSheet, Image } from 'react-native';
import { Ionicons } from '@expo/vector-icons';
import * as ImagePicker from 'expo-image-picker';

const ConsoleModal = ({ visible, onClose, onSubmit }) => {
  const [name, setName] = useState('');
  const [company, setCompany] = useState('');
  const [year, setYear] = useState('');
  const [description, setDescription] = useState('');
  const [rating, setRating] = useState(0);
  const [image, setImage] = useState(null);

  const pickImage = async (source) => {
    let result;
    
    if (source === 'gallery') {
      result = await ImagePicker.launchImageLibraryAsync({
        mediaTypes: ImagePicker.MediaTypeOptions.Images,
        allowsEditing: true,
        aspect: [4, 3],
        quality: 1,
      });
    } else {
      result = await ImagePicker.launchCameraAsync({
        allowsEditing: true,
        aspect: [4, 3],
        quality: 1,
      });
    }

    if (!result.canceled && result.assets) {
      setImage(result.assets[0].uri);
    }
  };

  const handleSubmit = () => {
    onSubmit({
      name,
      company,
      year,
      description,
      rating,
      image
    });
    onClose();
  };

  return (
    <Modal
      animationType="slide"
      transparent={true}
      visible={visible}
      onRequestClose={onClose}
    >
      <View style={styles.modalContainer}>
        <View style={styles.modalContent}>
          {/* ... outros campos permanecem iguais ... */}
          
          <Text style={styles.label}>Imagem</Text>
          <View style={styles.imageButtons}>
            <TouchableOpacity 
              style={styles.imageButton}
              onPress={() => pickImage('gallery')}
            >
              <Text>● Anexar (Galeria)</Text>
            </TouchableOpacity>
            <TouchableOpacity 
              style={styles.imageButton}
              onPress={() => pickImage('camera')}
            >
              <Text>● Adicionar (Câmera)</Text>
            </TouchableOpacity>
          </View>

          {image && (
            <View style={styles.imagePreview}>
              <Image 
                source={{ uri: image }} 
                style={styles.previewImage}
              />
              <TouchableOpacity 
                style={styles.removeImageButton}
                onPress={() => setImage(null)}
              >
                <Ionicons name="close-circle" size={24} color="red" />
              </TouchableOpacity>
            </View>
          )}

          {/* ... resto do modal permanece igual ... */}
        </View>
      </View>
    </Modal>
  );
};

const styles = StyleSheet.create({
  // ... estilos anteriores permanecem iguais ...
  
  imagePreview: {
    marginTop: 10,
    alignItems: 'center',
    position: 'relative',
  },
  previewImage: {
    width: 150,
    height: 150,
    borderRadius: 5,
  },
  removeImageButton: {
    position: 'absolute',
    right: 0,
    top: 0,
    backgroundColor: 'white',
    borderRadius: 12,
  },
});

export default ConsoleModal;