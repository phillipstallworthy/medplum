import { OperationOutcome, RegisterRequest } from '@medplum/core';
import { Button, Document, FormSection, Logo, MedplumLink, parseForm, TextField, useMedplum } from '@medplum/ui';
import React, { useState } from 'react';

export function RegisterPage() {
  const medplum = useMedplum();
  const [outcome, setOutcome] = useState<OperationOutcome>();
  const [success, setSuccess] = useState(false);

  return (
    <Document width={450}>
      <form style={{ maxWidth: 400 }} onSubmit={(e: React.SyntheticEvent) => {
        e.preventDefault();

        const formData = parseForm(e.target as HTMLFormElement) as any as RegisterRequest;
        medplum.register(formData)
          .then(() => setSuccess(true))
          .catch(err => {
            if (err.outcome) {
              setOutcome(err.outcome);
            }
          })
      }}>
        <div className="center">
          <Logo size={32} />
          <h1>Register new account</h1>
        </div>
        {!success && (
          <>
            <FormSection title="First Name">
              <TextField id="firstName" type="text" testid="firstName" required={true} autoFocus={true} outcome={outcome} />
            </FormSection>
            <FormSection title="Last Name">
              <TextField id="lastName" type="text" testid="lastName" required={true} outcome={outcome} />
            </FormSection>
            <FormSection title="Project Name">
              <TextField id="projectName" type="text" testid="projectName" required={true} outcome={outcome} />
            </FormSection>
            <FormSection title="Email">
              <TextField id="email" type="email" testid="email" required={true} outcome={outcome} />
            </FormSection>
            <FormSection title="Password">
              <TextField id="password" type="password" testid="password" required={true} outcome={outcome} />
            </FormSection>
            <div className="medplum-signin-buttons">
              <div>
                <MedplumLink testid="signin" to="/signin">Sign in</MedplumLink>
              </div>
              <div>
                <Button type="submit" testid="submit">Create account</Button>
              </div>
            </div>
          </>
        )}
        {success && (
          <div data-testid="success">Email sent</div>
        )}
      </form>
    </Document>
  );
}