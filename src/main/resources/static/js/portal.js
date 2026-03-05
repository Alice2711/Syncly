(() => {
  const isHome = document.body?.dataset?.page === "home";
  const isLogin = document.body?.dataset?.page === "login";
  const isSignup = document.body?.dataset?.page === "signup";

  // Basic polish: focus the most relevant input.
  if (isHome) {
    const q = document.querySelector('form.search input[name="q"]');
    if (q && !q.value) q.focus();
  }
  if (isLogin) {
    const email = document.querySelector('input[name="email"]');
    if (email) email.focus();
  }
  if (isSignup) {
    const email = document.querySelector('input[name="email"], input[id="email"]');
    if (email) email.focus();
  }
})();

