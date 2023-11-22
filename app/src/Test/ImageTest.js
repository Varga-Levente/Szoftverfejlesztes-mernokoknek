// ImageUploader.js
import React, { useState, useCallback } from 'react';
import { useDropzone } from 'react-dropzone';

const ImageTest = () => {
    const [imageData, setImageData] = useState('');

    const onDrop = useCallback((acceptedFiles) => {
        const file = acceptedFiles[0];

        if (file) {
            const reader = new FileReader();

            reader.onload = () => {
                const base64String = reader.result.split(',')[1];
                setImageData(base64String);
            };

            reader.readAsDataURL(file);
        }
    }, []);

    const { getRootProps, getInputProps } = useDropzone({ onDrop });

    return (
        <div>
            <div {...getRootProps()} style={{ border: '2px dashed #ccc', padding: '20px', textAlign: 'center' }}>
                <input {...getInputProps()} />
                <p>Drag & drop a image file here, or click to select one</p>
            </div>

            {imageData && (
                <div>
                    <h2>Uploaded Image:</h2>
                    <img src={`data:image/jpg;base64,${imageData}`} alt="Uploaded" style={{ maxWidth: '100%' }} />
                </div>
            )}
        </div>
    );
};

export default ImageTest;
