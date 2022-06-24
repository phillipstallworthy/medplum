import { MantineProvider } from '@mantine/core';
import { NotificationsProvider } from '@mantine/notifications';
import { MedplumClient } from '@medplum/core';
import { MedplumProvider } from '@medplum/react';
import React from 'react';
import { createRoot } from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import { App } from './App';

if ('serviceWorker' in navigator) {
  window.addEventListener('load', () => {
    navigator.serviceWorker
      .register('/service-worker.js')
      .then((reg) => {
        console.log('SW registered: ', reg);
        return reg.update();
      })
      .then((reg) => {
        console.log('SW updated: ', reg);
      })
      .catch((regError) => console.log('SW registration failed: ', regError));
  });
}

const medplum = new MedplumClient({
  baseUrl: process.env.MEDPLUM_BASE_URL as string,
  clientId: process.env.MEDPLUM_CLIENT_ID as string,
  cacheTime: 60000,
  autoBatchTime: 100,
  onUnauthenticated: () => (window.location.href = '/signin'),
});

const root = createRoot(document.getElementById('root') as HTMLElement);
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <MedplumProvider medplum={medplum}>
        <MantineProvider withGlobalStyles withNormalizeCSS>
          <NotificationsProvider position="bottom-right">
            <App />
          </NotificationsProvider>
        </MantineProvider>
      </MedplumProvider>
    </BrowserRouter>
  </React.StrictMode>
);
