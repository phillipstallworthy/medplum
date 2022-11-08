import { Button, Group, TextInput, Title } from '@mantine/core';
import { Form, useMedplum } from '@medplum/react';
import React, { useEffect, useState } from 'react';

export function MfaPage(): JSX.Element | null {
  const medplum = useMedplum();
  const [qrCodeUrl, setQrCodeUrl] = useState<string | undefined>(undefined);
  const [enrolled, setEnrolled] = useState<boolean | undefined>(undefined);

  useEffect(() => {
    medplum
      .get('auth/mfa/status')
      .then((response) => {
        const url = new URL('https://chart.googleapis.com/chart');
        url.searchParams.set('chs', '300x300');
        url.searchParams.set('cht', 'qr');
        url.searchParams.set('chl', response.enrollUri);
        url.searchParams.set('choe', 'UTF-8');
        setQrCodeUrl(url.toString());
        setEnrolled(response.enrolled);
      })
      .catch(console.log);
  }, [medplum]);

  if (enrolled === undefined) {
    return null;
  }

  if (enrolled) {
    return (
      <Group>
        <Title>MFA is enabled</Title>
        <Button onClick={() => medplum.post('auth/mfa/disable', {}).catch(console.log)}>Disable MFA</Button>
      </Group>
    );
  }

  return (
    <Form
      onSubmit={(formData: Record<string, string>) => {
        console.log('SUBMIT', formData);
        medplum
          .post('auth/mfa/enroll', formData)
          .then((res) => {
            console.log('RES', res);
            setEnrolled(true);
          })
          .catch((err) => console.log('error', err));
      }}
    >
      <Title>MFA Test</Title>
      <img src={qrCodeUrl as string} />
      <TextInput name="token" label="Code" />
      <Group position="right">
        <Button type="submit">Test</Button>
      </Group>
    </Form>
  );
}
