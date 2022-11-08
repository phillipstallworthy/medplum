import { Anchor, Button, Title } from '@mantine/core';
import { showNotification } from '@mantine/notifications';
import { formatHumanName, getReferenceString, normalizeErrorString, ProfileResource } from '@medplum/core';
import { HumanName, UserConfiguration } from '@medplum/fhirtypes';
import { DescriptionList, DescriptionListEntry, Document, useMedplum } from '@medplum/react';
import React, { useEffect, useState } from 'react';

interface SecurityDetails {
  profile: ProfileResource;
  config: UserConfiguration;
}

export function SecurityPage(): JSX.Element | null {
  const medplum = useMedplum();
  const [details, setDetails] = useState<SecurityDetails | undefined>();

  useEffect(() => {
    medplum
      .get('auth/me')
      .then(setDetails)
      .catch((err) => showNotification({ color: 'red', message: normalizeErrorString(err) }));
  }, [medplum]);

  if (!details) {
    return null;
  }

  return (
    <>
      <Document>
        <Title>Security</Title>
        <DescriptionList>
          <DescriptionListEntry term="ID">
            <Anchor href={`/${getReferenceString(details.profile)}`}>{details.profile.id}</Anchor>
          </DescriptionListEntry>
          <DescriptionListEntry term="Resource Type">{details.profile.resourceType}</DescriptionListEntry>
          <DescriptionListEntry term="Name">
            {formatHumanName(details.profile.name?.[0] as HumanName)}
          </DescriptionListEntry>
        </DescriptionList>
      </Document>
      <Document>
        <Title>Password</Title>
        <Button>Change password</Button>
      </Document>
      <Document>
        <Title>Multi Factor Auth</Title>
        <Button>Enroll</Button>
      </Document>
    </>
  );
}
