import React, { useState } from 'react';
import DesignationList from './DesignationList';
import DesignationForm from './DesignationForm';
import { Container, Row, Col } from 'react-bootstrap';

const DesignationPage = () => {
  const [selected, setSelected] = useState(null);

  return (
    <Container>
      <Row>
        <Col md={4}>
          <DesignationForm selected={selected} onSaveComplete={() => setSelected(null)} />
        </Col>
        <Col md={8}>
          <DesignationList onEdit={setSelected} />
        </Col>
      </Row>
    </Container>
  );
};

export default DesignationPage;
