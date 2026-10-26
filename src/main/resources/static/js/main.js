document.querySelectorAll('.term .line').forEach((el, i) => {
  el.style.animationDelay = (i * 70) + 'ms';
});

document.querySelectorAll('.copy').forEach(btn => {
  btn.addEventListener('click', () => {
    const el = document.getElementById(btn.dataset.copy);
    const done = () => { btn.textContent = 'copied'; setTimeout(() => { btn.textContent = 'copy'; }, 1400); };
    const select = () => {
      const range = document.createRange();
      range.selectNodeContents(el);
      const sel = getSelection();
      sel.removeAllRanges();
      sel.addRange(range);
    };
    if (navigator.clipboard) navigator.clipboard.writeText(el.textContent).then(done, select);
    else select();
  });
});

const form = document.getElementById('contact-form');
const note = document.getElementById('cf-note');

form.addEventListener('submit', async e => {
  e.preventDefault();
  const button = form.querySelector('button[type="submit"]');
  const body = {
    name: form.elements.name.value,
    email: form.elements.email.value,
    message: form.elements.message.value
  };

  button.disabled = true;
  note.className = 'note';
  note.textContent = 'Sending…';
  try {
    const res = await fetch('/api/contact', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(body)
    });
    const data = await res.json();
    if (res.ok) {
      note.className = 'note ok';
      note.textContent = data.message;
      form.reset();
    } else {
      note.textContent = data.message || 'Something in the form needs fixing.';
      if (data.field && form.elements[data.field]) form.elements[data.field].focus();
    }
  } catch (err) {
    note.textContent = 'Could not reach the server. Check your connection and try again.';
  } finally {
    button.disabled = false;
  }
});
