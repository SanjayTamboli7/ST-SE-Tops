function Cup({ guest }) {
    return <h4>Tea guest #{guest}</h4>;
  }
  
export default function TeaSet() {
    return (
        <>
        <Cup guest={1} />
        <Cup guest={2} />
        <Cup guest={3} />
        </>
    );
}
