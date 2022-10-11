import fetch from "node-fetch";

function say(what: string): string {
  return what;
}


async function fetchJson(url: string): Promise<unknown> {
  const response = await fetch(url);

  if (response.ok) {
    return response.json();
  }

  throw new Error(`Response was not ok: , ${response.status}`);
}

async function run(): Promise<void> {
  console.log(say("Hello, World"));

  const result = await fetchJson("https://raw.githubusercontent.com/iotaledger/tangle.js/main/tools/tangle-cli/tsconfig.json");

  console.log(result);
}

run().then().catch(err => console.error("Error:", err));

