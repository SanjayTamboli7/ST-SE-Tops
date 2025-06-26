import React, { useState, useEffect } from 'react';
import { Modal, Button, Form, Row, Col, Table } from 'react-bootstrap';

const emptyHeader = {
  grndate: '',
  grnno: '',
  pono: '',
  receivedby: '',
  remarks: '',
};

const emptyDetail = {
  itemid: '',
  quantity: '',
  rate: '',
  remark: '',
};

const GRNModal = ({
  show,
  onHide,
  onSave,
  initialData = null,
  poOptions = [],
  itemOptions = [],
  userOptions = [],
}) => {
  const [header, setHeader] = useState(emptyHeader);
  const [details, setDetails] = useState([ { ...emptyDetail } ]);

  useEffect(() => {
    if (initialData) {
      setHeader(initialData.header);
      setDetails(initialData.details.length ? initialData.details : [{ ...emptyDetail }]);
    } else {
      setHeader(emptyHeader);
      setDetails([{ ...emptyDetail }]);
    }
  }, [initialData, show]);

  const handleHeaderChange = (e) => {
    const { name, value } = e.target;
    setHeader((prev) => ({ ...prev, [name]: value }));
  };

  const handleDetailChange = (index, field, value) => {
    const updated = [...details];
    updated[index][field] = value;
    setDetails(updated);
  };

  const addDetailRow = () => {
    setDetails([...details, { ...emptyDetail }]);
  };

  const removeDetailRow = (index) => {
    const updated = [...details];
    updated.splice(index, 1);
    setDetails(updated.length ? updated : [{ ...emptyDetail }]);
  };

  const handleSubmit = () => {
    const payload = {
      header,
      details: details.filter(d => d.itemid && d.quantity),
    };
    onSave(payload);
  };

  return (
    <Modal show={show} onHide={onHide} size="lg">
      <Modal.Header closeButton>
        <Modal.Title>{initialData ? 'Edit GRN' : 'Add GRN'}</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form>
          <Row className="mb-3">
            <Col md={4}>
              <Form.Group controlId="grnno">
                <Form.Label>GRN No</Form.Label>
                <Form.Control
                  name="grnno"
                  value={header.grnno}
                  onChange={handleHeaderChange}
                />
              </Form.Group>
            </Col>
            <Col md={4}>
              <Form.Group controlId="grndate">
                <Form.Label>GRN Date</Form.Label>
                <Form.Control
                  type="date"
                  name="grndate"
                  value={header.grndate}
                  onChange={handleHeaderChange}
                />
              </Form.Group>
            </Col>
            <Col md={4}>
              <Form.Group controlId="pono">
                <Form.Label>PO No</Form.Label>
                <Form.Select
                  name="pono"
                  value={header.pono}
                  onChange={handleHeaderChange}
                >
                  <option value="">-- Select PO --</option>
                  {poOptions.map((po) => (
                    <option key={po.poid} value={po.poid}>
                      {po.pono}
                    </option>
                  ))}
                </Form.Select>
              </Form.Group>
            </Col>
          </Row>
          <Row className="mb-3">
            <Col md={6}>
              <Form.Group controlId="receivedby">
                <Form.Label>Received By</Form.Label>
                <Form.Select
                  name="receivedby"
                  value={header.receivedby}
                  onChange={handleHeaderChange}
                >
                  <option value="">-- Select User --</option>
                  {userOptions.map((user) => (
                    <option key={user.userid} value={user.userid}>
                      {user.username}
                    </option>
                  ))}
                </Form.Select>
              </Form.Group>
            </Col>
            <Col md={6}>
              <Form.Group controlId="remarks">
                <Form.Label>Remarks</Form.Label>
                <Form.Control
                  name="remarks"
                  value={header.remarks}
                  onChange={handleHeaderChange}
                />
              </Form.Group>
            </Col>
          </Row>

          <hr />
          <h5>GRN Details</h5>
          <Table bordered size="sm">
            <thead>
              <tr>
                <th>#</th>
                <th>Item</th>
                <th>Qty</th>
                <th>Rate</th>
                <th>Remark</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {details.map((detail, index) => (
                <tr key={index}>
                  <td>{index + 1}</td>
                  <td>
                    <Form.Select
                      value={detail.itemid}
                      onChange={(e) =>
                        handleDetailChange(index, 'itemid', e.target.value)
                      }
                    >
                      <option value="">-- Select Item --</option>
                      {itemOptions.map((item) => (
                        <option key={item.itemid} value={item.itemid}>
                          {item.itemname}
                        </option>
                      ))}
                    </Form.Select>
                  </td>
                  <td>
                    <Form.Control
                      type="number"
                      value={detail.quantity}
                      onChange={(e) =>
                        handleDetailChange(index, 'quantity', e.target.value)
                      }
                    />
                  </td>
                  <td>
                    <Form.Control
                      type="number"
                      value={detail.rate}
                      onChange={(e) =>
                        handleDetailChange(index, 'rate', e.target.value)
                      }
                    />
                  </td>
                  <td>
                    <Form.Control
                      value={detail.remark}
                      onChange={(e) =>
                        handleDetailChange(index, 'remark', e.target.value)
                      }
                    />
                  </td>
                  <td>
                    <Button
                      variant="danger"
                      size="sm"
                      onClick={() => removeDetailRow(index)}
                    >
                      Remove
                    </Button>
                  </td>
                </tr>
              ))}
              <tr>
                <td colSpan="6" className="text-center">
                  <Button size="sm" onClick={addDetailRow}>
                    + Add Detail
                  </Button>
                </td>
              </tr>
            </tbody>
          </Table>
        </Form>
      </Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={onHide}>
          Cancel
        </Button>
        <Button variant="primary" onClick={handleSubmit}>
          {initialData ? 'Update' : 'Save'}
        </Button>
      </Modal.Footer>
    </Modal>
  );
};

export default GRNModal;
