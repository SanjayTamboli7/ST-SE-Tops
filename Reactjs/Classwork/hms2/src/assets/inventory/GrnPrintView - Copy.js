import React, { useEffect, useState } from 'react';
import { Table, Button } from 'react-bootstrap';
import axios from 'axios';

const GrnPrintView = ({ grnid }) => {
  const [header, setHeader] = useState(null);
  const [details, setDetails] = useState([]);
  const [itemMap, setItemMap] = useState({});
  const [userMap, setUserMap] = useState({});

  useEffect(() => {
    if (grnid) {
      fetchHeader(grnid);
      fetchDetails(grnid);
    }
  }, [grnid]);

  const fetchHeader = async (id) => {
    const res = await axios.get(`http://localhost:8080/api/grns/${id}`);
    const headerData = res.data;

    // Fetch username for receivedBy
    try {
      const userRes = await axios.get(`http://localhost:8080/api/otherusers/${headerData.receivedby}`);
      headerData.receivedByName = userRes.data.ousername;
    } catch {
      headerData.receivedByName = '-';
    }

    setHeader(headerData);
  };

  const fetchDetails = async (id) => {
    const res = await axios.get(`http://localhost:8080/api/grns/${id}/details`);
    const rows = res.data || [];
    const itemMapLocal = {};
    for (const row of rows) {
      if (!itemMapLocal[row.itemid]) {
        try {
          const itemRes = await axios.get(`http://localhost:8080/api/items/${row.itemid}`);
          itemMapLocal[row.itemid] = itemRes.data.itemname;
        } catch {
          itemMapLocal[row.itemid] = 'Unknown';
        }
      }
    }
    setItemMap(itemMapLocal);
    setDetails(rows);
  };

  const handlePrint = () => {
    window.print();
  };

  if (!header) return <p>Loading...</p>;

  return (
    <div className="container mt-4">
      <h3>Goods Receipt Note</h3>
      <hr />
      <div>
        <p><strong>GRN ID:</strong> {header.grnid}</p>
        <p><strong>PO ID:</strong> {header.poid}</p>
        <p><strong>Received Date:</strong> {header.receiveddate}</p>
        <p><strong>Received By:</strong> {header.receivedByName}</p>
        <p><strong>Status:</strong> {header.status}</p>
      </div>

      <h5>Item Details</h5>
      <Table bordered size="sm">
        <thead>
          <tr>
            <th>#</th>
            <th>Item</th>
            <th>Ordered</th>
            <th>Received</th>
            <th>Accepted</th>
            <th>Rejected</th>
            <th>Batch No</th>
            <th>Expiry</th>
          </tr>
        </thead>
        <tbody>
          {details.map((d, idx) => (
            <tr key={d.grndetailid}>
              <td>{idx + 1}</td>
              <td>{itemMap[d.itemid] || '-'}</td>
              <td>{d.orderedqty}</td>
              <td>{d.receivedqty}</td>
              <td>{d.acceptedqty}</td>
              <td>{d.rejectedqty}</td>
              <td>{d.batchno}</td>
              <td>{d.expirydate}</td>
            </tr>
          ))}
        </tbody>
      </Table>
      <Button variant="primary" onClick={handlePrint}>Print GRN</Button>
    </div>
  );
};

export default GrnPrintView;
